package service;
import repository.HorseRepository;

public class HorseService {
    private static HorseService horseService;

    public static HorseService getInstance(){
        if(horseService == null) horseService = new HorseService();
        return horseService;
    }

    public void findAllHorse(){
        new HorseRepository().findAllHorse();
    }

    public void insertHorse(String horseName){
        new HorseRepository().insertHorse(horseName);
    }

    public void deleteHorse(String horseName){
        new HorseRepository().deleteHorse(horseName);
    }
}
