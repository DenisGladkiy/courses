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
import java.util.List;

/**
 * Created by Денис on 3/26/16.
 */
public class TableRows {

    private Connection connection;
    private DaoFactory daoFactory;

    public String[]  getTableRowById(int id){
        String sql = "SELECT * FROM carmarket.advert "+
                " INNER JOIN  carmarket.car ON carmarket.advert.idcar = " +
                "carmarket.car.idcar INNER JOIN carmarket.owner ON carmarket.car.idowner = carmarket.owner.idowner" ;
        daoFactory = new DaoFactory();
        String[] row = new String[7];
        try {
            connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                //System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" test");
                row[0] = String.valueOf(rs.getInt(1));
                row[1] = String.valueOf(rs.getInt(2));
                row[2] = String.valueOf(rs.getInt(3));
                row[3] = String.valueOf(rs.getInt(4));
                row[4] = String.valueOf(rs.getInt(2));
                row[5] = String.valueOf(rs.getInt(2));
                row[6] = String.valueOf(rs.getInt(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public String [][] getAllRows(){
        String[][] allRows = null;
        daoFactory = new DaoFactory();
        String[] row = null;
        try {
            connection = daoFactory.getConnection();
            AdvertDao aDao = daoFactory.getAdvertDao(connection);
            List<AdvertEntity> adverts = aDao.findAll();
            allRows = new String[adverts.size()][];
            int index = 0;
            for(AdvertEntity ae : adverts){
                row = getTableRowById(ae.getCarId());
                allRows[index] = row;
                index++;
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }

        return allRows;
    }
}
