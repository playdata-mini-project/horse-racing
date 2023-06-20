package util.view;

import java.util.Scanner;

public class UserViewInput {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MIN = 1;
    private static final int MAX = 4;

    public static void menu() {
        System.out.println("1. 유저 등록\t2. 전체 유저 조회\t3. 금액 충전\t4. 뒤로가기");
    }

    public static String selectMode(){
        String mode = sc.nextLine();
        validateMode(mode);
        return sc.nextLine();
    }

    private static void validateMode(String mode){
        int modeToInt = Integer.parseInt(mode);
        if(modeToInt<MIN || modeToInt>MAX){
            selectMode();
        }
    }


}
