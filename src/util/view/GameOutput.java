package util.view;

import domain.entity.horse.Horse;
import domain.entity.user.User;
import util.response.FinalPositionResp;
import util.response.WinnerHorseNamesResp;
import util.response.WinningUserNamesResp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameOutput {
    private static final String HORSE_POSITION_FORMAT = "%s : %s\n";
    private static final String OUTPUT_FORMAT = "말 %s와 유저 %s 최종 우승했습니다.";
    private static final String DELIMITER = ", ";

    public static void printWinningHorsesAndUsers(WinnerHorseNamesResp horsesResp, WinningUserNamesResp usersResp) {
        List<String> winnerHorseNames = horsesResp.getHorseNames();
        List<String> winnerUserNames = usersResp.getUserNames();

        winnerHorseNames.sort(String::compareTo);

        String horseName = String.join(DELIMITER, winnerHorseNames);
        String userName = String.join(DELIMITER, winnerUserNames);
        String message = String.format(OUTPUT_FORMAT, horseName, userName);

        System.out.println(message);
    }

    public static void printPosition(FinalPositionResp result) {
        Map<String, Integer> positionByNameMap = result.positionByHorseNameMap();

        String results = positionByNameMap.keySet().stream()
                .map(name -> String.format(HORSE_POSITION_FORMAT, name, makeBar(positionByNameMap.get(name))))
                .collect(Collectors.joining());

        System.out.println(results);
    }

    private static String makeBar(int size) {
        return IntStream.range(0, size)
                .mapToObj(it -> "-")
                .collect(Collectors.joining());
    }

    public static void printResultMessage() {
        System.out.println("경마 경기 결과");
    }
}
