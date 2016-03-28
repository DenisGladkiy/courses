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

    public AdvertDao(Connection connection){
        this.connection = connection;
    }
    public List<AdvertEntity> findAll() throws SQLException {
        List<AdvertEntity> entities = new ArrayList<AdvertEntity>();
        AdvertEntity advert = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.advert");
        while(rs.next()) {
            advert = new AdvertEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            entities.add(advert);
        }
        statement.close();
        return entities;
    }

    public AdvertEntity findById(int id) throws SQLException {
        AdvertEntity advert = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.advert WHERE idadvert ="+String.valueOf(id));
        while(rs.next()) {
            advert = new AdvertEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        }
        statement.close();
        return advert;
    }

    public boolean insert(AdvertEntity entity) {

        String query = "insert into carmarket.advert"+ "(idadvert, idcar, price) VALUES"
                + "(?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, entity.getAdvertId());
            statement.setInt(2, entity.getCarId());
            statement.setInt(3, entity.getPrice());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AdvertEntity remove(Long id) {
        return null;
    }
}
