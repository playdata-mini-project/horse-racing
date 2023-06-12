package domain.dto;

public class InsertUserDto {
    private final String name;
    private final String nickname;
    private final int money;

    public InsertUserDto(String name, String nickname, int money) {
        this.name = name;
        this.nickname = nickname;
        this.money = money;
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
}
