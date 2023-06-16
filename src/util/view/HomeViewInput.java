package util.view;

import java.util.Scanner;

public class HomeViewInput {
    private static final Scanner sc = new Scanner(System.in);

    private static final int MIN = 1;
    private static final int MAX = 3;

    public static void menu() {
        System.out.println("1. 유저 화면\t2. 말 화면\t3. 새 경마 게임 생성");
    }

    public static String selectMode() {
        String mode = sc.nextLine();
        validateMode(mode);
        return sc.nextLine();
    }

    private static void validateMode(String mode) {
        int modeToInt = Integer.parseInt(mode);
        if (modeToInt < MIN || modeToInt > MAX) {
            selectMode();
        }
    }
}