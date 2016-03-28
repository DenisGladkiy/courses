import dao.AdvertDao;
import dao.CarDao;
import dao.DaoFactory;
import dao.OwnerDao;
import entity.AdvertEntity;
import entity.CarEntity;
import entity.OwnerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Денис on 3/27/16.
 */
public class InsertData {

    /*public InsertData(Connection connection){
        this.connection = connection;
    }*/

    public static boolean insertData(String[] text) throws SQLException {
        DaoFactory daoFactory = new DaoFactory();
        Connection connection = daoFactory.getConnection();
        int id = getLastId(connection) + 1;
        OwnerEntity ownerEntity = new OwnerEntity(id, text[5], text[6], Integer.parseInt(text[7].replaceAll("\\s+","")));
        CarEntity carEntity = new CarEntity(id, id, Integer.parseInt(text[2].replaceAll("\\s+","")), text[0], text[1], text[3], text[8]);
        AdvertEntity advertEntity = new AdvertEntity(id, id, Integer.parseInt(text[4].replaceAll("\\s+","")));
        OwnerDao ownerDao = daoFactory.getOwnerDao(connection);
        CarDao carDao = daoFactory.getCarDao(connection);
        AdvertDao advertDao = daoFactory.getAdvertDao(connection);
        ownerDao.insert(ownerEntity);
        carDao.insert(carEntity);
        advertDao.insert(advertEntity);
        return true;
    }

    private static int getLastId(Connection con) throws SQLException {
        int lastId = 0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT idowner FROM  carmarket.owner");
        while (rs.next()) {
            if (lastId < rs.getInt("idowner")) {
                lastId = rs.getInt("idowner");
            }
        }
        System.out.println("lastid "+lastId);
        return lastId;
    }
}
