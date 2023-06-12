package domain.dto;

public class FindAllHorseDto {

    private final int id;
    private final String name;
    private final int average_rank;
    private final int injury;

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
