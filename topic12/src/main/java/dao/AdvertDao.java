package dao;

import entity.AdvertEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertDao implements DaoIn<AdvertEntity> {
    private Connection connection;

    public AdvertDao(Connection connection) {
        this.connection = connection;
    }

    public List<AdvertEntity> findAll() throws SQLException {
        List<AdvertEntity> entities = new ArrayList<AdvertEntity>();
        AdvertEntity advert = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM advert");
        while (rs.next()) {
            advert = new AdvertEntity(rs.getInt(2), rs.getInt(3));
            entities.add(advert);
        }
        statement.close();
        return entities;
    }

    public AdvertEntity findById(int id) throws SQLException {
        AdvertEntity advert = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM advert WHERE idadvert =" + String.valueOf(id));
        while (rs.next()) {
            advert = new AdvertEntity(rs.getInt(2), rs.getInt(3));
        }
        statement.close();
        return advert;
    }

    public Integer insert(AdvertEntity entity) {

        String query = "insert into advert" + "(idcar, price) VALUES"
                + "(?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getCarId());
            statement.setInt(2, entity.getPrice());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = 0;
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

    public AdvertEntity remove(int id) {
        return null;
    }
}
