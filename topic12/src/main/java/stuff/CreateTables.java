package stuff;

import dao.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Денис on 4/1/16.
 */
public class CreateTables {
    private static final String createOwnerTable = "CREATE TABLE owner ( idowner int(11) NOT NULL AUTO_INCREMENT," +
            "  name varchar(45) NOT NULL, surname varchar(45) NOT NULL," +
            "  phone int(11) NOT NULL, PRIMARY KEY (idowner)" +
            ") ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;";

    private static final String createCarTable = "CREATE TABLE car (idcar int(11) NOT NULL AUTO_INCREMENT," +
            "  idowner int(11) NOT NULL, year int(11) NOT NULL," +
            "  manufacturer varchar(45) NOT NULL, model varchar(45) NOT NULL," +
            "  vin varchar(45) NOT NULL, description varchar(200) NOT NULL," +
            "  PRIMARY KEY (idcar), KEY ownerFK_idx (idowner)," +
            "  CONSTRAINT ownerFK FOREIGN KEY (idowner) REFERENCES owner (idowner) ON DELETE CASCADE ON UPDATE CASCADE" +
            ") ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;";

    private static final String createAdvertTable = "CREATE TABLE advert (idadvert int(11) NOT NULL AUTO_INCREMENT," +
            " idcar int(11) NOT NULL, price int(11) NOT NULL, PRIMARY KEY (idadvert), " +
            " KEY carFK_idx (idcar), CONSTRAINT carFK FOREIGN KEY (idcar) REFERENCES car (idcar)" +
            " ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;";


    public static void createTables() {
        DaoFactory daoFactory = new DaoFactory();
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(createOwnerTable);
            statement.execute(createCarTable);
            statement.execute(createAdvertTable);
            statement.close();
            System.out.println("tables created");
        } catch (SQLException e) {
            System.out.println("tables exist");
            e.printStackTrace();
        }
    }
}
