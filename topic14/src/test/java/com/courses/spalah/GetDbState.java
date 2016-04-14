package com.courses.spalah;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Денис on 4/14/16.
 */
public class GetDbState {
    Connection connection;

    public GetDbState() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    public int getTotalRowsNumber() {
        int count = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM car");
            resultSet.next();
            count = resultSet.getInt("rowcount");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getSelectedRowsNumber(String query) {
        int count = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            count = resultSet.getInt("rowcount");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
