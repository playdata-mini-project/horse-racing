package domain.dto;

public class FindAllHorseDto {
    public FindAllHorseDto(int id, String name, int average_rank, int injury) {
        this.id = id;
        this.name = name;
        this.average_rank = average_rank;
        this.injury = injury;
    }

    private int id;
    private String name;
    private int average_rank;
    private int injury;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAverage_rank() {
        return average_rank;
    }
    private int getInjury(){
        return injury;
    }
}
