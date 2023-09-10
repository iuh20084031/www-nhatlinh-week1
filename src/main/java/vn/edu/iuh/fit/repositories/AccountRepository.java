package vn.edu.iuh.fit.repositories;

import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import vn.edu.iuh.fit.connect.ConnectionDB;
import vn.edu.iuh.fit.models.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class AccountRepository {
    private Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }
    public ArrayList<Account> getAllAccount() throws SQLException {
        ArrayList<Account> lst = new ArrayList<Account>();
        String sql="Select * from Phong";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String accountId = (String) resultSet.getString("account_id").trim();
            String fullName = resultSet.getString("full_name").trim();
            String password = resultSet.getString("password").trim();
            String email = resultSet.getString("email").trim();
            String phone = resultSet.getString("phone").trim();
            String status = resultSet.getString("status").trim();
            Account account = new Account(accountId,fullName, password,email,phone,status);
            lst.add(account);
        }
        return lst;
    }
}
