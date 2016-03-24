import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ievgen Tararaka
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // или любой другой драйвер
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "aspendendi"); // открытие соединения к базе
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM test.person");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rs.getString(i));
            }
        }
    }
}
