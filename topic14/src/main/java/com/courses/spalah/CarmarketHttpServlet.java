package com.courses.spalah;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 4/5/16.
 */
public class CarmarketHttpServlet extends HttpServlet {

    private static final String all = "SELECT * FROM advert " +
            " INNER JOIN  car ON advert.idcar = " +
            " car.idcar INNER JOIN owner ON car.idowner = owner.idowner";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<List<String>> carList = new ArrayList<>();
        PrintWriter printWriter = response.getWriter();
        ResultSet rs = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            SelectQueryBuilder queryBuilder = new SelectQueryBuilder();
            printWriter.write("doGet answer "+request.getParameter("vin"));
            printWriter.write("deGet "+request.getQueryString());
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
        printWriter.write("{ \n [ \n");
        for (List<String> car : carList) {
            printWriter.write(serialize(car));
        }
        printWriter.write("] \n }");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        StringBuilder sBuilder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        while(line!=null){
            printWriter.println(line);
            sBuilder.append(line);
            line = reader.readLine();
        }
        reader.close();
        String jsonInsert = sBuilder.toString();
        JsonObject jsonObject = new Gson().fromJson(jsonInsert, JsonObject.class);
        printWriter.println(jsonObject.get("manufacturer").getAsString());
        printWriter.println(jsonObject.get("modelName").getAsString());
        printWriter.println(jsonObject.get("year").getAsString());
        printWriter.println(jsonObject.get("vin").getAsString());
        printWriter.println(jsonObject.get("description").getAsString());
        printWriter.println(jsonObject.get("price").getAsString());
        printWriter.println(jsonObject.get("contact_phone").getAsString());
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

    private String serialize(List<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("{" + "\n" + "\"id\": " + list.get(0) + ",\n");
        builder.append("\"manufacturer\": \"" + list.get(1) + "\", \n");
        builder.append("\"model\": \"" + list.get(2) + "\", \n");
        builder.append("\"year\": " + list.get(3) + ", \n");
        builder.append("\"vin\": \"" + list.get(4) + "\", \n");
        builder.append("\"description\": \"" + list.get(5) + "\", \n");
        builder.append("\"price\": " + list.get(6) + ", \n");
        builder.append("\"phone\": " + list.get(7) + ", \n");
        builder.append("}, \n");
        return builder.toString();
    }
}
