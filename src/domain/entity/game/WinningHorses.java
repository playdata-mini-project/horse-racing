package domain.entity.game;

import domain.entity.horse.Horse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningHorses {

    private final List<Horse> horses;

    public WinningHorses(List<Horse> horses) {
        this.horses = judgeWinners(horses);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> judgeWinners(List<Horse> horses) {
        Horse winner = findWinner(horses);

        return horses.stream()
                .filter(horse -> horse.isSamePosition(winner))
                .collect(Collectors.toList());
    }

    private Horse findWinner(List<Horse> horses) {
        return horses.stream()
                .max(Comparator.comparing(Horse::getPosition))
                .orElseThrow(IllegalArgumentException::new);
    }

}