package util.response;

import domain.entity.horse.Horse;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerHorseNamesResponse {
    private final List<String> horseNames;

    public WinnerHorseNamesResponse(List<Horse> horses) {
        this.horseNames = horses.stream()
                .map(Horse::getName)
                .collect(Collectors.toList());
    }

    public List<String> getHorseNames() {
        return horseNames;
    }
}
