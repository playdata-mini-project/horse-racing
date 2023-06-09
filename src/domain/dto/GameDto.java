package domain.dto;

import java.time.LocalDateTime;

public class GameDto {
    private int id;
    private int totalMoney;
    private int totalUser;
    private LocalDateTime createdAt;

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