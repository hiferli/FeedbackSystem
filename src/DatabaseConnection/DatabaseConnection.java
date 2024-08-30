package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/JDBCDemo";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin@123Admin@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getCloudConnection() throws SQLException {
        final String CLOUD_URL = "jdbc:mysql://jarvis.mysql.database.azure.com/AzureDatabase";
        final String CLOUD_USER = "ishaan";
        final String CLOUD_PASSWORD = "Protiviti.co.in";

        return DriverManager.getConnection(CLOUD_URL , CLOUD_USER , CLOUD_PASSWORD);
    }
}