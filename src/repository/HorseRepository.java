package repository;
import config.JdbcConnection;
import domain.dto.FindAllHorseDto;

import java.sql.*;
public class HorseRepository {
    public void insertHorse(String horseName) {
        Connection connection = new JdbcConnection().getJdbc();
        String insertSql =  "insert into horse(name) value(?)";
        try {
            PreparedStatement psmt = connection.prepareStatement(insertSql);
            psmt.setString(1, horseName);
            if(psmt.executeUpdate()==0){
                System.out.println("insertHorse err");
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
    public void findAllHorse(){
        Connection connection = new JdbcConnection().getJdbc();
        String findAllSql =  "select * from horse";
         Integer id ;
         String name ;
         Integer average_rank;
         Integer injury;

        try {
            PreparedStatement psmt = connection.prepareStatement(findAllSql);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                average_rank = resultSet.getInt("average_rank");
                injury = resultSet.getInt("injury");
                System.out.println(id + " " + name + " " + average_rank + " " + injury);
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
    public void deleteHorse(String horseName){
        Connection connection = new JdbcConnection().getJdbc();
        String deleteSql =  "delete from horse where name = ?";
        try {
            PreparedStatement psmt = connection.prepareStatement(deleteSql);
            psmt.setString(1,horseName);
            if(psmt.executeUpdate()==0){
                System.out.println("deleteHorse err");
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
}
