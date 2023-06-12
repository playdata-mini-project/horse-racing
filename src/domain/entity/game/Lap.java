package domain.entity.game;

import java.util.Objects;

public class Lap {

    private static final int INIT_VALUE = 0;
    private static final int INCREASE = 1;
    private static final int LEAST_TOTAL_LAP_COUNT = 1;
    private final int value;

    private Lap(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static Lap totalLap(int value) {
        if (LEAST_TOTAL_LAP_COUNT > value) {
            throw new IllegalArgumentException("최소 바퀴 수는 1 이상 입니다.");
        }
        return new Lap(value);
    }

    public static Lap init() {
        return new Lap(INIT_VALUE);
    }

    public Lap increase() {
        return new Lap(this.value + INCREASE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lap)) return false;
        Lap lap = (Lap) o;
        return value == lap.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
