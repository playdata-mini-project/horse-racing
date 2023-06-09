package domain.entity;

import java.time.LocalDateTime;

public class Game {
    private int id;
    private int totalMoney;
    private int totalUser;
    private String name;
    private LocalDateTime createdAt;

    public Game(int id, int totalMoney, int totalUser, String name, LocalDateTime createdAt) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.totalUser = totalUser;
        this.name = name;
        this.createdAt = createdAt;
    }

    // 정적 팩토리 메서드
    public static Game toEntity(int id, int totalMoney, int totalUser, String name, LocalDateTime createdAt) {
        return new Game(id, totalMoney, totalUser, name, createdAt);
    }
}
