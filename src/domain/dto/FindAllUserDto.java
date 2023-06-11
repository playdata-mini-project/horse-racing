package domain.dto;

public class FindAllUserDto {
    private int id;
    private String name;
    private String nickname;
    private int money;
    private FindAllUserDto(){

    }
    public FindAllUserDto(int id, String name, String nickname, int money) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.money = money;
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

}
