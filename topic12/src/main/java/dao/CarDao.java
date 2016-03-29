package dao;

import entity.CarEntity;

import java.sql.*;
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
        statement.close();
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
        statement.close();
        return car;
    }

    public Integer insert(CarEntity entity) {
        String query = "insert into carmarket.car"+ "(idcar, idowner, year, manufacturer, model, vin, description) VALUES"
                + "(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getCarId());
            statement.setInt(2, entity.getOwnerId());
            statement.setInt(3, entity.getYear());
            statement.setString(4, entity.getManufacturer());
            statement.setString(5, entity.getModel());
            statement.setString(6, entity.getVin());
            statement.setString(7, entity.getDescription());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = 0;
            while(generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CarEntity remove(Long id) {
        return null;
    }
}
