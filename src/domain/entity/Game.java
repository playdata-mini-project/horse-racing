package domain.entity;

import java.time.LocalDateTime;

public class Game {
    private int id;
    private int totalMoney;
    private int totalUser;
    private String name;
    private LocalDateTime createdAt;

    public Game(){

    }
    public Game(int id, int totalMoney, int totalUser, String name, LocalDateTime createdAt) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.totalUser = totalUser;
        this.name = name;
        this.createdAt = createdAt;
    }


}
