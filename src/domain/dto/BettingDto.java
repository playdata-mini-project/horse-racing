package domain.dto;

public class BettingDto {
    private String horseName;
    private String userName;
    private int money;

    public BettingDto(String horseName, String userName, int money) {
        this.horseName = horseName;
        this.userName = userName;
        this.money = money;
    }

    public String getHorseName() {
        return horseName;
    }

    public String getUserName() {
        return userName;
    }

    public int getMoney() {
        return money;
    }
}
