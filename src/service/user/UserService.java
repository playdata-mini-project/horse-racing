package service.user;

import config.jdbc.JdbcConnection;
import domain.dto.user.FindAllUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static final Scanner sc = new Scanner(System.in);
    public void findAllUser() {
        List<FindAllUser> findAllUsers = new ArrayList<>();
        String sql = "select * from user";
        Connection conn = new JdbcConnection().getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                findAllUsers.add(new FindAllUser(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("money"),
                        resultSet.getFloat("hitRate"),
                        resultSet.getDate("createAt")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (FindAllUser findAllUser: findAllUsers) {
            System.out.println(findAllUser);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertUser() {
        //TODO: 유저 등록하고 끝나지 않게 하기
        Connection conn = new JdbcConnection().getConnection();
        String sql = "insert into user(name, money) " +
                "values(?, ?)";
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("money");
        int money = sc .nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,name );
            pst.setInt(2, money);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserMoney() {
        //TODO : db에 이름 있는지 검사 해주기
        Connection conn = new JdbcConnection().getConnection();
        String sql = "update user set money = money + ? " +
                "where name = ?";
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("money");
        int money = sc .nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,money );
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validationUserName(List<String> userNames) {

        String sql = "select name from user where name = ?";
        Connection conn = new JdbcConnection().getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (String name:userNames) {
                pst.setString(1,name);
                ResultSet resultSet = pst.executeQuery();
                if(!resultSet.next()) {
                    return false;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void updateUserHitRate(List<String> winningUsers) {
        //TODO : 승률 업데이트는 되는데 값이 이상한거같다 수정하기
        Connection conn = new JdbcConnection().getConnection();
        String sql = "UPDATE user\n" +
                "SET hitRate = ROUND(\n" +
                "  (SELECT AVG(cnt)\n" +
                "  FROM (\n" +
                "    SELECT COUNT(*) as cnt\n" +
                "    FROM gameresult\n" +
                "    WHERE winUser = ?\n" +
                "    GROUP BY winUser\n" +
                "  ) subquery),\n" +
                "  2\n" +
                ")\n" +
                "WHERE name = ?;";
        for (int i = 0; i < winningUsers.size(); i++) {
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,winningUsers.get(i) );
                pst.setString(2,winningUsers.get(i) );
                pst.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
