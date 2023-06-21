package util.response;

import domain.entity.horse.Horse;
import domain.entity.horse.Horses;

import java.util.Map;
import java.util.stream.Collectors;

public class FinalPositionResp {
    private final Map<String, Integer> positionByHorseName;

    public FinalPositionResp(Horses horses) {
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
