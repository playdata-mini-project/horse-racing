package domain.entity.horse;

import util.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Horses {

    private static final int SIZE = 5;
    private final List<Horse> horses;

    public Horses(List<String> horseNames) {
        if (horseNames.size() != SIZE) {
            throw new IllegalArgumentException("말은 5마리 존재해야 합니다.");
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