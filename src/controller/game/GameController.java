package controller.game;

import domain.entity.game.*;
import domain.entity.horse.Horses;
import domain.entity.user.Users;

import util.generator.NumberGenerator;
import util.response.FinalPositionResp;
import util.response.WinnerHorseNamesResp;
import util.response.WinningUserNamesResp;
import util.view.GameInput;
import util.view.GameOutput;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GameController {

    private final NumberGenerator numberGenerator;
    private static final String DELIMITER = ",";

    public GameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void gameStart() {
        Horses horses = createHorses();
        Users users = createUsers();
        Match match = Match.matching(horses, users);
        Lap targetLap = Lap.totalLap(GameInput.inputTargetLap());

        Game game = Game.init(numberGenerator, horses, users, match, targetLap);
        GameOutput.printResultMessage();
        start(game);
    }

    // 콘솔창으로 받아온 말 이름 나누고, 유효성 검사
    private Horses createHorses() {
        String horseNames = GameInput.inputHorseNames();

        return new Horses(Arrays.stream(horseNames.split(DELIMITER)).collect(Collectors.toList()));
    }

    // 콘솔창으로 받아온 유저 이름 나누고, 유효성 검사
    private Users createUsers() {
        String userNames = GameInput.inputMatchingUserNames();

        return new Users(Arrays.stream(userNames.split(DELIMITER)).collect(Collectors.toList()));
    }

    private void start(Game game) {
        while (game.hasMoreLap()) {
            game.start();
            GameOutput.printPosition(new FinalPositionResp(game.getHorses()));
        }

        Winners winners = game.winners();
        GameOutput.printWinningHorsesAndUsers(new WinnerHorseNamesResp(winners.getHorses()), new WinningUserNamesResp(winners.getUsers()));
    }
}