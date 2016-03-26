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
        OwnerEntity owner = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.owner WHERE idowner ="+String.valueOf(id));
        while(rs.next()) {
            owner = new OwnerEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        return owner;
    }

    public boolean insert(OwnerEntity entity) {
        return false;
    }

    public OwnerEntity remove(Long id) {
        return null;
    }
}
