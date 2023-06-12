package domain.dto;

import java.time.LocalDateTime;

public class GameDto {
    private final int id;
    private final int totalMoney;
    private final int totalUser;
    private final LocalDateTime createdAt;

    public GameDto(int id, int totalMoney, int totalUser, LocalDateTime createdAt) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.totalUser = totalUser;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }


    public int getTotalMoney() {
        return totalMoney;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}