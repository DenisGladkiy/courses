package dao;

import dao.DaoIn;
import entity.OwnerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class OwnerDao implements DaoIn<OwnerEntity> {

    Connection connection;

    public OwnerDao(Connection connection){
        this.connection = connection;
    }

    public List<OwnerEntity> findAll() {
        return null;
    }

    public OwnerEntity findById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM carmarket.owner WHERE idowner = 1");
        while(resultSet.next()) {
            String test = resultSet.getString(2);
            System.out.println(test);
        }
        return null;
    }

    public boolean insert(OwnerEntity entity) {
        return false;
    }

    public OwnerEntity remove(Long id) {
        return null;
    }
}
