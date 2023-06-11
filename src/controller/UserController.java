package controller;
import service.UserService;
import domain.dto.insertUserDto;
import java.util.Scanner;

public class UserController {
    private Scanner sc;
    private static UserService userService = new UserService();

    public void UserView() {
        while (true) {
            System.out.println("1. 유저 등록\t2. 유저 조회\t3. 코인 충전\t4. 유저 삭제\t5.뒤로가기");
            sc = new Scanner(System.in);
            String mode = sc.nextLine();
            switch (mode) {
                case "1":
                    insertUser();
                    break;
                case "2":
                    findAllUser();
                case "3":
                    updateMoney();
                case "4":
                    deleteUser();
            }
        }
    }


    private void insertUser(){
        System.out.println("이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("닉네임 입력 : ");
        String nickname= sc.nextLine();
        System.out.println("시드머니 입력 : ");
        int money = sc.nextInt();
        insertUserDto dto = new insertUserDto(name,nickname,money);
        UserService.insertUser(dto);
    }
    private void findAllUser() {
        userService.findAllUser();
    }
    private void updateMoney(){
        System.out.println("충전 할 유저 이름 입력");
        String userName = sc.nextLine();
        System.out.println("충전 할 금액 입력");
        int money = sc.nextInt();
        userService.updateMoney(userName,money);
    }
    private void deleteUser() {
        System.out.println("삭제할 유저 입력 : ");
        String userName = sc.nextLine();
        userService.deleteUser(userName);
    }
}