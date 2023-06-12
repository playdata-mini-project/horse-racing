package domain.entity.horse;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int MOVE_INTERVAL = 1;
    private static final int INIT_VALUE = 0;
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public static Position init() {
        return new Position(INIT_VALUE);
    }

    public Position increase() {
        return new Position(this.value + MOVE_INTERVAL);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final Position position) {
        return this.value - position.value;
    }
}
