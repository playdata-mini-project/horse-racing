package util.view;

import java.util.Scanner;

public class GameInput {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputHorseNames() {
        System.out.println("경주할 말 이름을 입력하세요 (이름은 쉼표(,)를 기준 기준으로 구분).");
        return sc.nextLine();
    }

    public static String inputMatchingUserNames() {
        System.out.println("말 순서에 맞춰 유저를 매칭해주세요 (이름은 쉼표(,)를 기준 기준으로 구분).");
        return sc.nextLine();
    }

    public static int inputTargetLap() {
        System.out.println("목표 횟수를 입력해주세요.");
        String input = sc.nextLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("목표 바퀴 수는 숫자만 입력 가능합니다.");
        }
    }
}
