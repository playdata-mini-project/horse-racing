package util.view;

import domain.entity.horse.Horse;
import domain.entity.user.User;
import util.response.FinalPositionResponse;
import util.response.WinningHorseResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Output {
    private static final String HORSE_POSITION_FORMAT = "%s : %s\n";
    private static final String OUTPUT_FORMAT = "말 %s와 유저 %s 최종 우승했습니다.";
    private static final String DELIMITER = ", ";
    public static void printWinningHorsesAndUsers(WinningHorseResponse result, Map<Horse, User> matchMap) {
        List<String> winningHorses = result.winningHorseNames();
        List<String> winningUsers =  new ArrayList<>();

        for(Map.Entry<Horse, User> e : matchMap.entrySet()){
            if (winningHorses.contains(e.getKey().getName())) {
                winningUsers.add(e.getValue().getName());
            }
        }

        winningHorses.sort(String::compareTo);

        String horseName = String.join(DELIMITER, winningHorses);
        String userName = String.join(DELIMITER, winningUsers);
        String message = String.format(OUTPUT_FORMAT, horseName, userName);

        System.out.println(message);
    }

    public static void printPosition(FinalPositionResponse result) {
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
