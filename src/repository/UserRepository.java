package repository;

import config.jdbc.JdbcConnection;
import domain.dto.FindAllUserDto;
import domain.dto.InsertUserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public void insertUser(InsertUserDto dto) {
        Connection connection = new JdbcConnection().getConnection();
        String insertSql =  "insert into user(name, nickname, money) value(?,?,?)";
        try {
            PreparedStatement psmt = connection.prepareStatement(insertSql);
            psmt.setString(1,dto.getName() );
            psmt.setString(2,dto.getNickname() );
            psmt.setInt(3,dto.getMoney() );
            if(psmt.executeUpdate()==0){
                System.out.println("insertUser err");
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
    public void findAllUser(){
        FindAllUserDto dto;
        Connection connection = new JdbcConnection().getConnection();
        String findAllUserSql =  "select * from user";
        int id;
        String name;
        String nickname;
        int money;

        try {
            PreparedStatement psmt = connection.prepareStatement(findAllUserSql);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                nickname = resultSet.getString("nickname");
                money = resultSet.getInt("money");
                System.out.println(id + " " + name + " " + nickname + " " + money);
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
    public void updateMoney(String userName, int money){
        Connection connection = new JdbcConnection().getConnection();
        String updateSql =  "update user set money = money + ? where name = ?";
        try {
            PreparedStatement psmt = connection.prepareStatement(updateSql);
            psmt.setInt(1,money);
            psmt.setString(2,userName);
            if(psmt.executeUpdate()==0){
                System.out.println("updateMoney err");
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
    public void deleteUser(String userName){
        Connection connection = new JdbcConnection().getConnection();
        String deleteSql =  "delete from user where name = ?";
        try {
            PreparedStatement psmt = connection.prepareStatement(deleteSql);
            psmt.setString(1,userName);
            if(psmt.executeUpdate()==0){
                System.out.println("deleteUser err");
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
