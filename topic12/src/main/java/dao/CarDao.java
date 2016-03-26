package dao;

import entity.CarEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class CarDao implements DaoIn<CarEntity> {

    Connection connection;

    public CarDao(Connection connection){
        this.connection = connection;
    }

    public List<CarEntity> findAll() throws SQLException {
        List<CarEntity> entities = null;
        CarEntity car = null;
        Statement statement = null;
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.car");
        while(rs.next()) {
            car = new CarEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7));
            entities.add(car);
        }
        return entities;
    }

    public CarEntity findById(int id) throws SQLException {
        CarEntity car = null;
        Statement statement = null;
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                    "SELECT * FROM carmarket.car WHERE idcar ="+String.valueOf(id));
            while(rs.next()) {
                car = new CarEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
            }
        return car;
    }

    public boolean insert(CarEntity entity) {
        return false;
    }

    public CarEntity remove(Long id) {
        return null;
    }
}
