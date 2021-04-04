package example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "Lietkabelis123";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException exception) {
            System.out.println("Connection failed");
            throw new SQLException(exception);
        }
    }
}
