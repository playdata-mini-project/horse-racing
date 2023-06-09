package repository;
import config.JdbcConnection;
import domain.dto.findAllHorseDto;

import java.sql.*;
public class HorseRepository {
    public void insertHorse(String horseName) {
        Connection connection = new JdbcConnection().getJdbc();
        String registerSql =  "insert into horse(name) value(?)";
        try {
            PreparedStatement psmt = connection.prepareStatement(registerSql);
            psmt.setString(1,horseName);
            if(psmt.executeUpdate()==0){
                System.out.println("insertHorse err");
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
    public void findAllHorse(){
        findAllHorseDto dto;
        Connection connection = new JdbcConnection().getJdbc();
        String findAllSql =  "select * from horse";
         Integer id = null;
         String name = null;
         Integer average_rank = null;

        try {
            PreparedStatement psmt = connection.prepareStatement(findAllSql);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                average_rank = resultSet.getInt("average_rank");
                dto = new findAllHorseDto(id,name,average_rank);
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
            // throw(RuntimeException) 에러발생시 프로그램 종료
            System.out.println("connection 닫기 실패");
        }
    }
}
