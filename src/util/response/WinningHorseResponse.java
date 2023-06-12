package util.response;

import domain.entity.horse.Horse;

import java.util.List;
import java.util.stream.Collectors;

public class WinningHorseResponse {
    private final List<String> horseNames;

    public WinningHorseResponse(List<Horse> horseNames) {
        this.horseNames = horseNames.stream()
                .map(Horse::getName)
                .collect(Collectors.toList());
    }

    public List<String> winningHorseNames() {
        return horseNames;
    }
}
