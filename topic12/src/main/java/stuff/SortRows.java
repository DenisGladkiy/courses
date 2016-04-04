package stuff;

import dao.DaoFactory;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

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
    private final static String Join = "SELECT * FROM advert INNER JOIN  car " +
            "ON advert.idcar = car.idcar INNER JOIN owner " +
            "ON car.idowner = owner.idowner";

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
