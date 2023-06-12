package service;

import domain.dto.BettingDto;
import repository.GameRepository;

public class GameService {
    private static GameService gameService;
    public static GameService getInstance(){
        if(gameService == null) gameService = new GameService();
        return gameService;
    }
    public static void findGameHorse(){
        new GameRepository().findGameHorse();
    }
   public void betting(BettingDto dto){
        new GameRepository().betting(dto);
    }

}
