package domain.entity.horse;

import java.time.LocalDateTime;

public class Horse {
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
