package vn.edu.iuh.fit.connect;

import org.mariadb.jdbc.Connection;
import vn.edu.iuh.fit.constants.Constants;

import java.sql.*;

public class ConnectionDB {
    public static Connection connection =null;
    private static ConnectionDB instance = new ConnectionDB();
    public static void connectToDatabase() throws SQLException {
        String url = Constants.DATABASE_URL;
        String user = Constants.DATABASE_USERNAME;
        String password = Constants.DATABASE_PASSWORD;
        connection = (Connection) DriverManager.getConnection(url,user,password);
    }
    public static ConnectionDB getInstance() {
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
    public void disconnect() throws SQLException{
        if(connection != null) {
            connection.close();
        }
    }
}
