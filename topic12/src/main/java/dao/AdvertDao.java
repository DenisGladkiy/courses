package dao;

import entity.AdvertEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public class AdvertDao implements DaoIn<AdvertEntity> {
    private Connection connection;

    public AdvertDao(Connection connection){
        this.connection = connection;
    }
    public List<AdvertEntity> findAll() {
        return null;
    }

    public AdvertEntity findById(int id) {
        return null;
    }

    public boolean insert(AdvertEntity entity) {
        return false;
    }

    public AdvertEntity remove(Long id) {
        return null;
    }
}
