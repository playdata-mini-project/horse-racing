package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String url = "jdbc:mysql://localhost:3306/horse_racing"+
                        "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

    private static final String user = "horseracing";
    private static final String password = "horseracing";

    public static Connection getConn() {
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
