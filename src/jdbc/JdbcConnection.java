package util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    // 로컬 사용일 경우 user, password, url ip 주소
    private static final String url = "jdbc:mysql://192.168.0.203:3306/kiosk"+
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