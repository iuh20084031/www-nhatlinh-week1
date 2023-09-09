package vn.edu.iuh.fit.connect;

import org.mariadb.jdbc.Connection;
import vn.edu.iuh.fit.constants.Constants;

import java.sql.*;

public class ConnectionUtil {
    private Connection connection;
    private static ConnectionUtil connectionUtil;
    public ConnectionUtil(){
        String url = Constants.DATABASE_URL;
        String user = Constants.DATABASE_USERNAME;
        String password = Constants.DATABASE_PASSWORD;
        try {
            connection = (Connection) DriverManager.getConnection(url, user , password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ConnectionUtil getDBConnection() throws ClassNotFoundException, SQLException {
        if (connectionUtil == null) {
            connectionUtil = new ConnectionUtil();
        }
        return connectionUtil;
    }
    public Connection getConnection() {
        return connection;
    }
}
