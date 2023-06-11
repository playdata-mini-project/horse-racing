package service;
import repository.HorseRepository;

public class HorseService {
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
