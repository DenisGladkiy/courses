package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Денис on 3/25/16.
 */
public class DaoFactory {
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/carmarket";
    private String driver = "com.mysql.jdbc.Driver";

    public DaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public AdvertDao getAdvertDao(Connection connection) {
        return new AdvertDao(connection);
    }

    public CarDao getCarDao(Connection connection) {
        return new CarDao(connection);
    }

    public OwnerDao getOwnerDao(Connection connection) {
        return new OwnerDao(connection);
    }
}
