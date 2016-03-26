import dao.AdvertDao;
import dao.CarDao;
import dao.DaoFactory;
import dao.OwnerDao;
import entity.AdvertEntity;
import entity.CarEntity;
import entity.OwnerEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Денис on 3/26/16.
 */
public class TableRow {

    private Connection connection;
    private DaoFactory daoFactory;

    public String[]  getTableRowById(int id){
        daoFactory = new DaoFactory();
        String[] row = null;
        try {
            connection = daoFactory.getConnection();
            OwnerDao oDao = daoFactory.getOwnerDao(connection);
            AdvertDao aDao = daoFactory.getAdvertDao(connection);
            CarDao cDao = daoFactory.getCarDao(connection);
            OwnerEntity oEntity = oDao.findById(id);
            AdvertEntity aEntity = aDao.findById(id);
            CarEntity cEntity = cDao.findById(id);
            //System.out.println(aEntity.toString() + cEntity.toString() + oEntity.toString());
            row = new String[]{cEntity.getManufacturer(), cEntity.getModel(), String.valueOf(cEntity.getYear()),
                                cEntity.getVin(), cEntity.getDescription(), String.valueOf(aEntity.getPrice()),
                                oEntity.getPhone()+"\n"+oEntity.getName()};
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
                row = getTableRowById(ae.getAdvertId());
                allRows[index] = row;
                index++;
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }

        return allRows;
    }
}
