package util.response;

import domain.entity.horse.Horse;
import domain.entity.horse.Horses;

import java.util.Map;
import java.util.stream.Collectors;

public class FinalPositionResponse {
    private final Map<String, Integer> positionByHorseName;

    public FinalPositionResponse(Horses horses) {
        positionByHorseName = horses.getHorses()
                .stream()
                .collect(Collectors.toMap(
                        Horse::getName, horse -> horse.getPosition().getValue())
                );
    }

    public Map<String, Integer> positionByHorseNameMap() {
        return positionByHorseName;
    }
}
