package com.courses.spalah;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 4/9/16.
 */
public class InsertNewAdvert {
    private final static String queryOwner = "insert into owner" + "(name, surname, phone) VALUES"
            + "(?,?,?)";
    private final static String queryCar = "insert into car" +
            "(idowner, year, manufacturer, model, vin, description) VALUES"
            + "(?,?,?,?,?,?)";
    private final static String queryAdvert = "insert into advert (idcar, price) VALUES (?,?)";
    Connection connection;

    public InsertNewAdvert(){
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.getConnection();
    }

    public boolean insert(Map<String, String> advert){
        int ownerId = insertOwner(advert);
        advert.put("ownerId", String.valueOf(ownerId));
        int carId = insertCar(advert);
        advert.put("carId", String.valueOf(carId));
        insertAdvert(advert);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Integer insertOwner(Map<String, String> advert){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(queryOwner, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, advert.get("name"));
            statement.setString(2, advert.get("surname"));
            statement.setInt(3, Integer.parseInt(advert.get("contact_phone")));
            statement.execute();
            int id = 0;
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Integer insertCar(Map<String, String> advert){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(queryCar, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, Integer.parseInt(advert.get("ownerId")));
            statement.setInt(2, Integer.parseInt(advert.get("year")));
            statement.setString(3, advert.get("manufacturer"));
            statement.setString(4, advert.get("modelName"));
            statement.setString(5, advert.get("vin"));
            statement.setString(6, advert.get("description"));
            statement.executeUpdate();
            int id = 0;
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertAdvert(Map<String, String> advert) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(queryAdvert);
            statement.setInt(1, Integer.parseInt(advert.get("carId")));
            statement.setInt(2, Integer.parseInt(advert.get("price")));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
