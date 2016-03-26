package dao;

import entity.AdvertEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public AdvertEntity findById(int id) throws SQLException {
        AdvertEntity advert = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM carmarket.advert WHERE idadvert ="+String.valueOf(id));
        while(rs.next()) {
            advert = new AdvertEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        }
        return advert;
    }

    public boolean insert(AdvertEntity entity) {
        return false;
    }

    public AdvertEntity remove(Long id) {
        return null;
    }
}
