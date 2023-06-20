package domain.entity.horse;

import controller.game.GameController;
import service.horse.HorseService;
import util.generator.NumberGenerator;
import util.view.GameInput;

import java.util.List;
import java.util.stream.Collectors;

public class Horses {

    private static final int SIZE = 5;
    private final List<Horse> horses;

    public Horses(List<String> horseNames) {

        if (horseNames.size() != SIZE) {
            throw new IllegalArgumentException("말은 5마리 존재해야 합니다.");
        }

        if(!new HorseService().validationHorseName(horseNames)){
            throw new IllegalArgumentException("등록되지 않은 말입니다.");
            //TODO: throw new IllegalArgumentException
        }

        this.horses = horseNames.stream()
                .map(Horse::new)
                .collect(Collectors.toList());


    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(NumberGenerator numberGenerator) {
        horses.forEach(horse -> horse.run(numberGenerator));
    }

}

