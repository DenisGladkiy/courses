package dao;

import entity.OwnerEntity;
import gui.MainFrame;

import java.sql.*;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class OwnerDao implements DaoIn<OwnerEntity> {

    private Connection connection;
    private final static String selectAll = "SELECT * FROM owner";
    private final static String selectById = "SELECT * FROM owner WHERE idowner = ?";
    private final static String query = "insert into owner" + "(name, surname, phone) VALUES"
            + "(?,?,?)";
    private final static String sql_remove = "DELETE FROM owner WHERE idowner = ?";

    public OwnerDao(Connection connection) {
        this.connection = connection;
    }

    public List<OwnerEntity> findAll() throws SQLException {
        List<OwnerEntity> entities = null;
        OwnerEntity owner = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectAll);
        while (rs.next()) {
            owner = new OwnerEntity(rs.getString(2), rs.getString(3), rs.getInt(4));
            entities.add(owner);
        }
        statement.close();
        return entities;
    }

    public OwnerEntity findById(int id) throws SQLException {
        OwnerEntity owner = null;
        PreparedStatement statement = connection.prepareStatement(selectById);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            owner = new OwnerEntity(rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        statement.close();
        return owner;
    }

    public Integer insert(OwnerEntity entity) {
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
        try {
            OwnerEntity ownerEntity = findById(id);
            PreparedStatement statement = connection.prepareStatement(sql_remove);
            statement.setInt(1, id);
            statement.executeUpdate();
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.refreshTable();
            return ownerEntity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
