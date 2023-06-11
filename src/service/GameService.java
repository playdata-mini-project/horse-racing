package service;

import domain.dto.InsertUserDto;
import repository.GameRepository;

import java.util.List;

public class GameService {
    public static void findGameHorse(){
        new GameRepository().findGameHorse();
    }
//    public void betting(){
//        new GameRepository().findAllUser();
//    }
//    public void gameStart(String name, int money){
//
//        new GameRepository().updateMoney(name,money);
//    }
}
