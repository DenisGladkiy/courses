package dao;

import entity.CarEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class CarDao implements DaoIn<CarEntity> {

    Connection connection;

    public CarDao(Connection connection){
        this.connection = connection;
    }

    public List<CarEntity> findAll() {
        return null;
    }

    public CarEntity findById(int id) {
        return null;
    }

    public boolean insert(CarEntity entity) {
        return false;
    }

    public CarEntity remove(Long id) {
        return null;
    }
}
