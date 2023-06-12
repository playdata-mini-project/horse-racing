package domain.entity.horse;

import util.generator.NumberGenerator;

public class Horse {

    private static final int REF_NUM = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final String name;
    private Position position;

    public Horse(String name) {
        this.name = name;
        this.position = Position.init();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void run(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate(MIN_RANGE, MAX_RANGE);
        validateRange(number);
        position = nextPosition(number);
    }

    private void validateRange(int randomNum) {
        if (randomNum < MIN_RANGE || randomNum > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private Position nextPosition(int randomNum) {
        if (randomNum >= REF_NUM) {
            return position.increase();
        }

        return position;
    }

    public boolean isSamePosition(Horse horse) {
        return this.position.equals(horse.position);
    }
}
