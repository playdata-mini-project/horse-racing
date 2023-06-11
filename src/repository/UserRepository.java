package repository;

import config.JdbcConnection;
import domain.dto.findAllUserDto;
import domain.dto.insertUserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRepository {
    public void insertUser(insertUserDto dto) {
        Connection connection = new JdbcConnection().getJdbc();
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
        findAllUserDto dto;
        Connection connection = new JdbcConnection().getJdbc();
        String findAllUserSql =  "select * from user";
        Integer id = null;
        String name = null;
        String nickname = null;
        Integer money = null;

        try {
            PreparedStatement psmt = connection.prepareStatement(findAllUserSql);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                nickname = resultSet.getString("nickname");
                money = resultSet.getInt("money");
                dto = new findAllUserDto(id,name,nickname,money);
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
        Connection connection = new JdbcConnection().getJdbc();
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
        Connection connection = new JdbcConnection().getJdbc();
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
