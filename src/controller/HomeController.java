package controller;

import java.util.Scanner;

public class HomeController {
    public void homeView(){
        System.out.println("1. 유저 화면\t2. 말 화면\t3. 새 경마 게임 생성");
        Scanner sc = new Scanner(System.in);
        String mode = sc.nextLine();
        if (mode.equals("1")){
            new UserController().UserView();
        }
        if(mode.equals("2")){
            new HorseController().HorseView();
        }

    }
}
