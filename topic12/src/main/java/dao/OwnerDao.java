package dao;

import dao.DaoIn;
import entity.OwnerEntity;

import java.sql.*;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class OwnerDao implements DaoIn<OwnerEntity> {

    Connection connection;

    public OwnerDao(Connection connection) {
        this.connection = connection;
    }

    public List<OwnerEntity> findAll() throws SQLException {
        List<OwnerEntity> entities = null;
        OwnerEntity owner = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.owner");
        while (rs.next()) {
            owner = new OwnerEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            entities.add(owner);
        }
        statement.close();
        return entities;
    }

    public OwnerEntity findById(int id) throws SQLException {
        OwnerEntity owner = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.owner WHERE idowner =" + String.valueOf(id));
        while (rs.next()) {
            owner = new OwnerEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        statement.close();
        return owner;
    }

    public boolean insert(OwnerEntity entity) {
        String query = "insert into carmarket.owner"+ "(idowner, name, surname, phone) VALUES"
                + "(?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, entity.getOwnerId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getSurname());
            statement.setInt(4, entity.getPhone());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public OwnerEntity remove(Long id) {
        return null;
    }
}
