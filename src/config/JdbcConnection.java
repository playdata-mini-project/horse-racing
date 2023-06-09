package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {


    private final String url = "jdbc:mysql://localhost:3306/horse_racing_db" + "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String root = "root";
    private final String number = "1234";
    public Connection getJdbc(){
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, root, number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("연동 성공");
        return connection;
    }
}
