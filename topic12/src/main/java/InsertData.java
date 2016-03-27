import dao.DaoFactory;
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
        //AdvertEntity advert = new AdvertEntity(id, id, Integer.valueOf(text[0]));
        return false;
    }

    private static int getLastId(Connection con) throws SQLException {
        int lastId = 0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM  carmarket.owner where idowner > "+lastId);
        while (rs.next()){
            lastId = rs.getInt("idowner");
        }
        return lastId;
    }
}
