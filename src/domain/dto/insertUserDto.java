package domain.dto;

public class insertUserDto {
    private String name;
    private String nickname;
    private int money;

    public insertUserDto(String name, String nickname, int money) {
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
