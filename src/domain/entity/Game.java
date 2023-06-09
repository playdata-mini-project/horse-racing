package domain.entity;

import java.time.LocalDateTime;

public class Game {
    private int id;
    private int totalMoney;
    private int totalUser;
    private LocalDateTime createdAt;

    public Game(int id, int totalMoney, int totalUser, LocalDateTime createdAt) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.totalUser = totalUser;
        this.createdAt = createdAt;
    }
}
