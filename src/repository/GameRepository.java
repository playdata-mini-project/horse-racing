package repository;

import config.JdbcConnection;
import domain.dto.FindAllHorseDto;
import domain.dto.FindAllUserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRepository {
    public void findGameHorse() {
        Connection connection = new JdbcConnection().getJdbc();
        String findGameHorseSql = "select * from horse order by rand() limit 10;";
        Integer id = null;
        String name = null;
        Integer average_rank = null;

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
            // throw(RuntimeException) 에러발생시 프로그램 종료
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