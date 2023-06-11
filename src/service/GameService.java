package service;

import domain.dto.BettingDto;
import repository.GameRepository;

public class GameService {
    public static void findGameHorse(){
        new GameRepository().findGameHorse();
    }
   public void betting(BettingDto dto){
        new GameRepository().betting(dto);
    }
    public void gameStart(){
    new StartGame().startGame();
    }
}
