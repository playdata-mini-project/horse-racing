package domain.entity;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name; // 유저 이름
    private String nickname; // 유저 닉네임
    private int money; // 충전된 돈
    private LocalDateTime createdAt; // 유저 생성 날짜
    public User(){

    }
    public User(int id, String name, String nickname, int money, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.money = money;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getMoney() {
        return money;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
