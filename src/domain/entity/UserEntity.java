package domain.entity;

import java.time.LocalDateTime;

public class UserEntity {
    private int user = 0; // 참여할 수 있는 유저
    private int id; // 유저의 고유 아이디
    private int name; // 유저 이름
    private int nickname; // 유저 닉네임
    private int money; // 충전된 돈
    private int account; // 게임 후 잔액
    private LocalDateTime createdAt; // 유저 생성 날짜

    public UserEntity(int user, int id, int name, int nickname, int money, int account, LocalDateTime createdAt) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.money = money;
        this.account = account;
        this.createdAt = createdAt;
    }
}
