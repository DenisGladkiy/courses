package com.courses.spalah;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 4/6/16.
 */
public class SelectQueryBuilder {
    private final static String selectAds = "SELECT * FROM advert INNER JOIN  car " +
            "ON advert.idcar = car.idcar INNER JOIN owner " +
            "ON car.idowner = owner.idowner";

    public String createStatement(String queryString) {
        List<String> select = parseQuery(queryString);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(selectAds);
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

    private List<String> parseQuery(String queryString) {
        List<String> query = new ArrayList<>();
        query.add(getValueFromQuery(queryString, "manufacturer"));
        query.add(getValueFromQuery(queryString, "modelName"));
        query.add(getValueFromQuery(queryString, "yearFrom"));
        query.add(getValueFromQuery(queryString, "yearTo"));
        query.add(getValueFromQuery(queryString, "priceFrom"));
        query.add(getValueFromQuery(queryString, "priceTo"));
        return query;
    }

    private String getValueFromQuery(String query, String key) {
        String[] str = query.split("&");
        for (String s : str) {
            if (s.contains(key)) {
                return s.substring(s.indexOf("=") + 1);
            }
        }
        return "";
    }

    private boolean isManufacturerSet(List<String> select) {
        return !select.get(0).equals("");
    }

    private boolean isModelSet(List<String> select) {
        return !select.get(1).equals("");
    }

    private boolean isYearFromSet(List<String> select) {
        return !select.get(2).equals("");
    }

    private boolean isPriceFromSet(List<String> select) {
        return !select.get(4).equals("");
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

    private String appendManufacturerModel(List<String> select) {
        return " WHERE car.manufacturer = " + "'" + select.get(0) + "'" +
                " AND car.model = " + "'" + select.get(1) + "'";
    }

    private String appendManufacturer(List<String> select) {
        return " WHERE car.manufacturer = " + "'" + select.get(0) + "'";
    }

    private String appendModel(List<String> select) {
        return " WHERE car.model = " + "'" + select.get(1) + "'";
    }

    private String whereYearFromTo(List<String> select) {
        int yearFrom = parseYears(select)[0];
        int yearTo = parseYears(select)[1];
        return " WHERE car.year > " + yearFrom + " AND car.year < " + yearTo;
    }

    private String andYearFromTo(List<String> select) {
        int yearFrom = parseYears(select)[0];
        int yearTo = parseYears(select)[1];
        return " AND car.year > " + yearFrom + " AND car.year < " + yearTo;
    }

    private String wherePriceFromTo(List<String> select) {
        int priceFrom = parsePrice(select)[0];
        int priceTo = parsePrice(select)[1];
        return " WHERE advert.price > " + priceFrom + " AND advert.price < " + priceTo;
    }

    private int[] parseYears(List<String> years) {
        int[] parsedYears = new int[2];
        try {
            parsedYears[0] = Integer.parseInt(years.get(2));
            parsedYears[1] = Integer.parseInt(years.get(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedYears;
    }

    private int[] parsePrice(List<String> price) {
        int[] parsedPrice = new int[2];
        try {
            parsedPrice[0] = Integer.parseInt(price.get(4));
            parsedPrice[1] = Integer.parseInt(price.get(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedPrice;
    }

    private String andPriceFromTo(List<String> select) {
        int priceFrom = parsePrice(select)[0];
        int priceTo = parsePrice(select)[1];
        return " AND advert.price > " + priceFrom + " AND advert.price < " + priceTo;
    }
}
