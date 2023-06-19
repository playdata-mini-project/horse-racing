package config.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/horse_racing_db"
            + "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "rlatnehd@123";

    public static Connection getConnection(){
        Connection conn;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}