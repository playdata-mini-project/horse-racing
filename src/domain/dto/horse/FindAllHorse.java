package domain.dto.horse;

import java.util.Date;

public class FindAllHorse {
    private int id;
    private String name;
    private int age;
    private float height;
    private float weight;
    private float winRate;

    public FindAllHorse(int id, String name, int age, float height, float weight, float winRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.winRate = winRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public float getWinRate() {
        return winRate;
    }
    @Override
    public String toString() {
        return "FindAllHorse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", winRate=" + winRate +
                '}';
    }
}
