package domain.entity;

import java.time.LocalDateTime;

public class Horse {
    private int id;
    private String name;
    private int average_rank;
    private float injury;
    private LocalDateTime created_at;
// cont 유저랑 /repo db랑
    public Horse(){

    }
    public Horse(int id, String name, int average_rank, float injury, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.average_rank = average_rank;
        this.injury = injury;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAverage_rank() {
        return average_rank;
    }

    public float getInjury() {
        return injury;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setAverage_rank(int average_rank) {
        this.average_rank = average_rank;
    }

    public void setInjury(float injury) {
        this.injury = injury;
    }

}
