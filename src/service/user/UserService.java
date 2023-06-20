package service.user;

import config.jdbc.JdbcConnection;
import domain.dto.user.FindAllUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
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
    }
}
