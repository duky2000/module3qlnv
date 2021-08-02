package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSql {


    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/quanlynhanvien";
        String jdbcUsername = "root";
        String jdbcPassword = "0988568002";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
