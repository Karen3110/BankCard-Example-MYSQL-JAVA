package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToSQL {

    private static final String user = "root";
    private static final String password = "1234567890";
    private static final String DB = "card";
    private static final String url = "jdbc:mysql://localhost:3306/"+DB;

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);

            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        }

        return connection;
    }

}
