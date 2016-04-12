package com.courses.spalah;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 4/12/16.
 */
public class GetAdverts {
    private static final String all = "SELECT * FROM advert " +
            " INNER JOIN  car ON advert.idcar = " +
            " car.idcar INNER JOIN owner ON car.idowner = owner.idowner";

    public List<List<String>> getData(HttpServletRequest request){
        List<List<String>> carList = new ArrayList<>();
        Connection connection = null;
        ResultSet rs = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            connection = factory.getConnection();
            Statement statement = connection.createStatement();
            SelectQueryBuilder queryBuilder = new SelectQueryBuilder();
            if (request.getQueryString() != null) {
                String select = queryBuilder.createStatement(request.getQueryString());
                rs = statement.executeQuery(select);
            } else {
                rs = statement.executeQuery(all);
            }
            while (rs.next()) {
                carList.add(makeRow(rs));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    private List<String> makeRow(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(rs.getInt(1)));
        list.add(rs.getString(7));
        list.add(rs.getString(8));
        list.add(String.valueOf(rs.getInt(6)));
        list.add(rs.getString(9));
        list.add(rs.getString(10));
        list.add(String.valueOf(rs.getInt(3)));
        list.add(String.valueOf(rs.getInt(14)));
        return list;
    }
}
