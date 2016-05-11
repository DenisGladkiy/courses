package com.courses.spalah.stuff;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.entity.CarEntity;
import com.courses.spalah.entity.OwnerEntity;
import com.courses.spalah.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Денис on 3/26/16.
 */
public class TableRows {

    private static final String sql = "SELECT * FROM advert " +
            " INNER JOIN  car ON advert.idcar = " +
            " car.idcar INNER JOIN owner ON car.idowner = owner.idowner";

    public String[][] getAllRows() {
        String[][] allRows = null;
        String hql = "from AdvertEntity";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        //CarEntity car = (CarEntity) session.load(CarEntity.class, 40);
        List<AdvertEntity> adverts = query.list();
        System.out.println("adverts size  "+adverts.size());
        //AdvertEntity advert = (AdvertEntity) session.load(AdvertEntity.class, 40);
        //System.out.println(advert);

        allRows = new String[adverts.size()][];
        for(int i = 0; i < adverts.size(); i++){
            System.out.println();
            allRows[i] = makeRow(adverts.get(i));
        }
        session.close();
        return allRows;
    }

    private String[] makeRow(AdvertEntity advert) {
        CarEntity car = advert.getCar();
        OwnerEntity owner = car.getOwner();
        String manufacturer = car.getManufacturer();
        String model = car.getModel();
        String year = String.valueOf(car.getYear());
        String vin = car.getVin();
        String description = car.getDescription();
        String price = String.valueOf(advert.getPrice());
        String contact = owner.getName() + " " + owner.getSurname() + " " + String.valueOf(owner.getPhone());
        String[] row = new String[]{manufacturer, model, year, vin, description, price, contact};
        return row;
    }
}
