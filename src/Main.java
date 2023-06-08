import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/testDB" +
                "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

            Connection conn;

            try {
                conn = DriverManager
                        .getConnection(url, "root", "rlatnehd@123");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        System.out.println("connection success");
    }
}