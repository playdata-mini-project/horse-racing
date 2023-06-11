package controller;
import service.HorseService;

import java.util.Scanner;
public class HorseController {
    private Scanner sc;
    private static HorseService horseService = new HorseService();

    public void HorseView() {
        while (true) {
            System.out.println("1. 말 등록\t2. 말 조회\t3. 말 등록 취소\t4. 뒤로가기");
            sc = new Scanner(System.in);
            String mode = sc.nextLine();
            switch (mode) {
                case "1":
                    insertHorse();
                    break;
                case "2":
                    findAllHorse();
                    break;
                case "3":
                    deleteHorse();
                    break;
                case "4":
                    HomeController homeController = new HomeController();
                    homeController.homeView();
            }
        }
    }

    private void insertHorse() {
        System.out.println("말 이름 입력 : ");
        String horseName = sc.nextLine();
        horseService.insertHorse(horseName);
    }
    private void findAllHorse() {
        horseService.findAllHorse();
    }
    private void deleteHorse() {
        System.out.println("삭제할 말 이름 입력 : ");
        String horseName = sc.nextLine();
        horseService.deleteHorse(horseName);
    }

}
