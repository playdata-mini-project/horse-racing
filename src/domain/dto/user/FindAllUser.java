package domain.dto.user;

import java.util.Date;

public class FindAllUser {
    private int id;
    private String name;
    private int money;
    private float hitRate;
    private Date createAt;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public float getHitRate() {
        return hitRate;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public FindAllUser(int id, String name, int money, float hitRate, Date createAt) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.hitRate = hitRate;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "FindAllUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", hitRate=" + hitRate +
                ", createAt=" + createAt +
                '}';
    }
}
