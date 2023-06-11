package repository;

import domain.entity.Game;

import java.util.List;

public interface GameRepository {
    List<Game> findGames();
    int createGame(Game game);
    int deleteGame(int id);
}