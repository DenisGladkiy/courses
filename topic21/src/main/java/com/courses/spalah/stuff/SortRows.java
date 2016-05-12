package com.courses.spalah.stuff;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.entity.CarEntity;
import com.courses.spalah.entity.OwnerEntity;
import com.courses.spalah.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Денис on 3/31/16.
 */
public class SortRows {
    private final static String Join = "FROM AdvertEntity INNER JOIN  CarEntity " +
            "ON AdvertEntity.idcar = CarEntity.idcar INNER JOIN OwnerEntity " +
            "ON CarEntity.idowner = OwnerEntity.idowner";

    public String[][] sortTable(String[] select) {
        String hql_select = createStatement(select);
        System.out.println("hql query  "+hql_select);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql_select);
        List<AdvertEntity> adverts = query.list();
        String[][] allRows = new String[adverts.size()][];
        for(int i = 0; i < adverts.size(); i++){
            allRows[i] = makeRow(adverts.get(i));
        }
        session.close();
        return allRows;
    }

    private String createStatement(String[] select) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Join);
        if (isManufacturerSet(select) && isModelSet(select)) {
            stringBuilder.append(appendManufacturerModel(select));
        } else if (isManufacturerSet(select)) {
            stringBuilder.append(appendManufacturer(select));
        } else if (isModelSet(select)) {
            stringBuilder.append(appendModel(select));
        }
        if (isFirstCondition(stringBuilder) && isYearFromSet(select)) {
            stringBuilder.append(whereYearFromTo(select));
        } else if (isYearFromSet(select)) {
            stringBuilder.append(andYearFromTo(select));
        }
        if (isFirstCondition(stringBuilder) && isPriceFromSet(select)) {
            stringBuilder.append(wherePriceFromTo(select));
        } else if (isPriceFromSet(select)) {
            stringBuilder.append(andPriceFromTo(select));
        }
        return stringBuilder.toString();
    }

    private boolean isFirstCondition(StringBuilder stringBuilder) {
        String statement = stringBuilder.toString();
        String last = statement.substring(statement.length() - 7);
        if (last.equals("idowner")) {
            return true;
        } else {
            return false;
        }
    }

    private int[] parseYears(String[] years) {
        int[] parsedYears = new int[2];
        try {
            parsedYears[0] = Integer.parseInt(years[2]);
            parsedYears[1] = Integer.parseInt(years[3]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please, check year input");
            e.printStackTrace();
        }
        return parsedYears;
    }

    private int[] parsePrice(String[] price) {
        int[] parsedPrice = new int[2];
        try {
            parsedPrice[0] = Integer.parseInt(price[4]);
            parsedPrice[1] = Integer.parseInt(price[5]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please, check price input");
            e.printStackTrace();
        }
        return parsedPrice;
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

    private String[][] listToArr(List<String[]> list) {
        String[][] array = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private boolean isManufacturerSet(String[] select) {
        return !select[0].equals("");
    }

    private boolean isModelSet(String[] select) {
        return !select[1].equals("");
    }

    private String appendManufacturerModel(String[] select) {
        return " WHERE car.manufacturer = " + "'" + select[0] + "'" +
                " AND car.model = " + "'" + select[1] + "'";
    }

    private String appendManufacturer(String[] select) {
        return " WHERE car.manufacturer = " + "'" + select[0] + "'";
    }

    private String appendModel(String[] select) {
        return " WHERE car.model = " + "'" + select[1] + "'";
    }

    private String whereYearFromTo(String[] select) {
        int yearFrom = parseYears(select)[0];
        int yearTo = parseYears(select)[1];
        return " WHERE car.year > " + yearFrom + " AND car.year < " + yearTo;
    }

    private String andYearFromTo(String[] select) {
        int yearFrom = parseYears(select)[0];
        int yearTo = parseYears(select)[1];
        return " AND car.year > " + yearFrom + " AND car.year < " + yearTo;
    }

    private String wherePriceFromTo(String[] select) {
        int priceFrom = parsePrice(select)[0];
        int priceTo = parsePrice(select)[1];
        return " WHERE advert.price > " + priceFrom + " AND advert.price < " + priceTo;
    }

    private String andPriceFromTo(String[] select) {
        int priceFrom = parsePrice(select)[0];
        int priceTo = parsePrice(select)[1];
        return " AND advert.price > " + priceFrom + " AND advert.price < " + priceTo;
    }

    private boolean isYearFromSet(String[] select) {
        return !select[2].equals("");
    }

    private boolean isPriceFromSet(String[] select) {
        return !select[4].equals("");
    }
}
