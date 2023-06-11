package repository;

import config.JdbcConnection;
import domain.dto.BettingDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRepository {
    public void findGameHorse() {
        Connection connection = new JdbcConnection().getJdbc();
        String findGameHorseSql = "select * from horse order by rand() limit 10;";
        Integer id;
        String name;
        Integer average_rank;

        try {
            PreparedStatement psmt = connection.prepareStatement(findGameHorseSql);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                average_rank = resultSet.getInt("average_rank");
                System.out.println(id + " " + name + " " + average_rank);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {

            System.out.println("connection 닫기 실패");
        }
    }
    public void betting(BettingDto dto) {
        Connection connection = new JdbcConnection().getJdbc();
        String bettingSql = "insert into betting where horseName = ? values(?,?)";
        String moneySql = "update user set money = money - ? where name = ?";
        try {
            PreparedStatement psmt = connection.prepareStatement(bettingSql); //배팅
            psmt.setString(1, dto.getHorseName());
            psmt.setString(2, dto.getUserName());
            psmt.setInt(3,dto.getMoney());
            PreparedStatement psmt1 = connection.prepareStatement(moneySql); // 배팅후 금액 차감
            psmt1.setInt(1,dto.getMoney());
            psmt1.setString(2, dto.getUserName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {

            System.out.println("connection 닫기 실패");
        }
    }
}