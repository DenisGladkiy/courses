package com.courses.spalah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Денис on 4/6/16.
 */
public class ConnectionFactory {
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/carmarket";
    private String driver = "com.mysql.jdbc.Driver";

    public ConnectionFactory(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
