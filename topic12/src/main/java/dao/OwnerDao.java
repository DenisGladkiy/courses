package dao;

import entity.OwnerEntity;
import gui.MainFrame;

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
                "SELECT * FROM owner");
        while (rs.next()) {
            owner = new OwnerEntity(rs.getString(2), rs.getString(3), rs.getInt(4));
            entities.add(owner);
        }
        statement.close();
        return entities;
    }

    public OwnerEntity findById(int id) throws SQLException {
        OwnerEntity owner = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM owner WHERE idowner =" + String.valueOf(id));
        while (rs.next()) {
            owner = new OwnerEntity(rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        statement.close();
        return owner;
    }

    public Integer insert(OwnerEntity entity) {
        String query = "insert into owner" + "(name, surname, phone) VALUES"
                + "(?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setInt(3, entity.getPhone());
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

    public OwnerEntity remove(int id) {
        String sql_remove = "DELETE FROM owner WHERE idowner = " + id;
        try {
            OwnerEntity ownerEntity = findById(id);
            Statement statement = connection.createStatement();
            statement.execute(sql_remove);
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.refreshTable();
            return ownerEntity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
