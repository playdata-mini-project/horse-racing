package util.view;

import java.util.Scanner;

public class HorseViewInput {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MIN = 1;
    private static final int MAX = 5;

    public static void menu() {
        System.out.println("1. 전체 말 조회\t");
//
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
