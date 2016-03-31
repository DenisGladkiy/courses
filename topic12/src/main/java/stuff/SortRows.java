package stuff;

import dao.DaoFactory;

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

    public String[][] sortTable(String[] select) {
        List<String[]> sortedTable = new ArrayList<>();
        String sql_select = createStatement(select);
        DaoFactory daoFactory = new DaoFactory();
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql_select);
            while (resultSet.next()) {
                sortedTable.add(makeRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listToArr(sortedTable);
    }

    private String createStatement(String[] select) {
        int yearFrom = 0;
        int yearTo = 0;
        int priceFrom = 0;
        int priceTo = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM carmarket.advert INNER JOIN  carmarket.car ON carmarket.advert.idcar = " +
                "carmarket.car.idcar INNER JOIN carmarket.owner ON carmarket.car.idowner = carmarket.owner.idowner");
        if (!select[0].equals("") && !select[1].equals("")) {
            stringBuilder.append(" WHERE carmarket.car.manufacturer = " + "'" + select[0] + "'" +
                    " AND carmarket.car.model = " + "'" + select[1] + "'");
        } else if (!select[0].equals("")) {
            stringBuilder.append(" WHERE carmarket.car.manufacturer = " + "'" + select[0] + "'");
        } else if (!select[1].equals("")) {
            stringBuilder.append(" WHERE carmarket.car.model = " + "'" + select[1] + "'");
        }
        if (isFirstCondition(stringBuilder) && !select[2].equals("")) {
            yearFrom = parseYears(select)[0];
            yearTo = parseYears(select)[1];
            stringBuilder.append(" WHERE carmarket.car.year > " + yearFrom + " AND carmarket.car.year < " + yearTo);
        } else if (!select[2].equals("")) {
            yearFrom = parseYears(select)[0];
            yearTo = parseYears(select)[1];
            stringBuilder.append(" AND carmarket.car.year > " + yearFrom + " AND carmarket.car.year < " + yearTo);
        }
        if (isFirstCondition(stringBuilder) && !select[4].equals("")) {
            priceFrom = parsePrice(select)[0];
            priceTo = parsePrice(select)[1];
            stringBuilder.append(" WHERE carmarket.advert.price > " + priceFrom + " AND carmarket.advert.price < " + priceTo);
        } else if (!select[4].equals("")) {
            priceFrom = parsePrice(select)[0];
            priceTo = parsePrice(select)[1];
            stringBuilder.append(" AND carmarket.advert.price > " + priceFrom + " AND carmarket.advert.price < " + priceTo);
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

    private String[][] listToArr(List<String[]> list) {
        String[][] array = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
