package com.courses.spalah.stuff;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.entity.CarEntity;
import com.courses.spalah.entity.OwnerEntity;
import com.courses.spalah.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Денис on 3/27/16.
 */
public class InsertData {
    private static OwnerEntity owner;
    private static CarEntity car;
    private static AdvertEntity advert;

    public static boolean insertData(String[][] text) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        createOwner(text[2]);
        session.save(owner);
        createCar(text[1], owner);
        session.save(car);
        createAdvert(text[0], car);
        session.save(advert);
        session.close();
        return true;
    }

    private static void createOwner(String[] ownerString) {
        owner = new OwnerEntity();
        owner.setName(ownerString[0]);
        owner.setSurname(ownerString[1]);
        owner.setPhone(Integer.parseInt(ownerString[2].replaceAll("\\s+", "")));
    }

    private static void createCar(String[] carString, OwnerEntity owner) {
        car = new CarEntity();
        car.setOwner(owner);
        car.setOwnerId(owner.getIdowner());
        car.setManufacturer(carString[0]);
        car.setModel(carString[1]);
        car.setYear(Integer.parseInt(carString[2].replaceAll("\\s+", "")));
        car.setVin(carString[3]);
        car.setDescription(carString[4]);
    }

    private static void createAdvert(String[] advertString, CarEntity car) {
        advert = new AdvertEntity();
        advert.setCar(car);
        advert.setCarId(car.getCarId());
        advert.setPrice(Integer.parseInt(advertString[0].replaceAll("\\s+", "")));
    }
}
