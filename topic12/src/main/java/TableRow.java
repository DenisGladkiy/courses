import dao.AdvertDao;
import dao.CarDao;
import dao.DaoFactory;
import dao.OwnerDao;
import entity.AdvertEntity;
import entity.CarEntity;
import entity.OwnerEntity;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Денис on 3/26/16.
 */
public class TableRow {

    Connection connection;
    DaoFactory daoFactory;

    public String  getTableRowById(int id){
        daoFactory = new DaoFactory();
        String row = null;
        try {
            connection = daoFactory.getConnection();
            OwnerDao oDao = daoFactory.getOwnerDao(connection);
            AdvertDao aDao = daoFactory.getAdvertDao(connection);
            CarDao cDao = daoFactory.getCarDao(connection);
            OwnerEntity oEntity = oDao.findById(id);
            AdvertEntity aEntity = aDao.findById(id);
            CarEntity cEntity = cDao.findById(id);
            //System.out.println(aEntity.toString() + cEntity.toString() + oEntity.toString());
            row = aEntity.toString() + cEntity.toString() + oEntity.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }
}
