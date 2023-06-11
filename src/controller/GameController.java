package controller;

import util.Back;
import java.util.Scanner;
import service.GameService;

public class GameController {
    private Scanner sc;
    private static GameService gameService = new GameService();

    public void GameView(){
        while (true) {
            System.out.println("1. 참가 말 조회\t2. 배팅\t3. 게임시작\t4. 뒤로가기");
            sc = new Scanner(System.in);
            String mode = sc.nextLine();
            switch (mode) {
                case "1":
                    findGameHorse();
                    break;
                case "2":
                    //betting();
                    break;
                case "3":
                    //gameStart();
                    break;
                case "4":
                   Back.back();
            }
        }
    }

private void findGameHorse(){
    gameService.findGameHorse();

}
//private void betting(){
//
//}
//private void gameStart(){
//
//}
}

