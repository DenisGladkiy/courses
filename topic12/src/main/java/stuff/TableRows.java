package stuff;

import dao.AdvertDao;
import dao.DaoFactory;
import entity.AdvertEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Денис on 3/26/16.
 */
public class TableRows {

    public String[][] getAllRows() {
        String sql = "SELECT * FROM carmarket.advert " +
                " INNER JOIN  carmarket.car ON carmarket.advert.idcar = " +
                "carmarket.car.idcar INNER JOIN carmarket.owner ON carmarket.car.idowner = carmarket.owner.idowner";
        String[][] allRows = null;
        DaoFactory daoFactory = new DaoFactory();
        try {
            Connection connection = daoFactory.getConnection();
            AdvertDao aDao = daoFactory.getAdvertDao(connection);
            List<AdvertEntity> adverts = aDao.findAll();
            allRows = new String[adverts.size()][];
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            int index = 0;
            while (rs.next()) {
                allRows[index] = makeRow(rs);
                index++;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRows;
    }

    private String[] makeRow(ResultSet rs) throws SQLException {
        String manufacturer = rs.getString(7);
        String model = rs.getString(8);
        String year = String.valueOf(rs.getInt(6));
        String vin = rs.getString(9);
        String description = rs.getString(10);
        String price = String.valueOf(rs.getInt(3));
        String contact = rs.getString(12) + " " + rs.getString(13) + " " + String.valueOf(rs.getInt(2));
        String[] row = new String[]{manufacturer, model, year, vin, description, price, contact};
        return row;
    }
}
