package controller.game;

import domain.entity.game.Game;
import domain.entity.game.Lap;
import domain.entity.game.WinningHorses;
import domain.entity.horse.Horse;
import domain.entity.horse.Horses;
import domain.entity.user.User;
import domain.entity.user.Users;

import util.generator.NumberGenerator;
import util.response.FinalPositionResponse;
import util.response.WinnerHorseNamesResponse;
import util.view.GameInput;
import util.view.GameOutput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameController {

    // 말, 유저 최대 필요 개수
    private static final int HORSE_USER_TOTAL_NUM = 5;
    private final NumberGenerator numberGenerator;
    private static final String DELIMITER = ",";
    private final Map<Horse, User> matchMap = new HashMap<>();

    public GameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void gameStart() {
        Horses horses = createHorses();
        Users users = createUsers();
        Lap targetLap = Lap.totalLap(GameInput.inputTargetLap());

        setMatchMap(horses, users);

        Game game = Game.init(numberGenerator, horses, users, targetLap);
        GameOutput.printResultMessage();
        start(game);
    }

    private Horses createHorses() {
        String horseNames = GameInput.inputHorseNames();

        return new Horses(Arrays.stream(horseNames.split(DELIMITER)).collect(Collectors.toList()));
    }

    private Users createUsers() {
        String userNames = GameInput.inputMatchingUserNames();

        return new Users(Arrays.stream(userNames.split(DELIMITER)).collect(Collectors.toList()));
    }

    private void start(Game game) {
        while (game.hasMoreLap()) {
            game.start();
            GameOutput.printPosition(new FinalPositionResponse(game.getHorses()));
        }
        WinningHorses winningHorses = game.winner();
        GameOutput.printWinningHorsesAndUsers(new WinnerHorseNamesResponse(winningHorses.getHorses()), matchMap);
    }

    private void setMatchMap(Horses horses, Users users) {
        List<Horse> horseList = horses.getHorses();
        List<User> userList = users.getUsers();

        for (int i = 0; i < HORSE_USER_TOTAL_NUM; i++) {
            matchMap.put(horseList.get(i), userList.get(i));
        }
    }
}