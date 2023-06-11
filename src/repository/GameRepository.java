package repository;

import domain.entity.Game;

import java.util.List;

public interface GameRepository {
    List<Game> findGames();
    int createGame(Game game);
    int deleteGame(int id);
}

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
//public class JoinHorse {
//    public Horse selectHorse(String horseId) {
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String sql = "select * from horse where horse_id ='" + horseId + "'";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//        ) {
//            while (rs.next()) {
//                int horse_id = rs.getInt("horse_id");
//                int horse_injury = rs.getInt("horse_injury");
//                return new Horse(horse_id, horse_injury;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}