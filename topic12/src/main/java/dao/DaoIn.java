package dao;

import entity.DaoEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Денис on 3/25/16.
 */
public interface DaoIn <T extends DaoEntity> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    boolean insert(T entity);
    T remove(Long id);
}
