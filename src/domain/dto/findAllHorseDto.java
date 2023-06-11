package domain.dto;

public class findAllHorseDto {
    public findAllHorseDto(int id, String name, int average_rank) {
        this.id = id;
        this.name = name;
        this.average_rank = average_rank;
    }

    private int id;
    private String name;
    private int average_rank;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAverage_rank() {
        return average_rank;
    }
}
