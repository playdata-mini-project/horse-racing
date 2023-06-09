package domain.entity.game;

import domain.entity.horse.Horses;
import domain.entity.user.Users;
import util.generator.NumberGenerator;


public class Game {

    private static final int PRIZE = 100000;

    private final NumberGenerator numberGenerator;
    private final Horses horses;
    private final Users users;
    private final Match match;
    private final Lap targetLap;
    private Lap currLap;

    public Game(NumberGenerator numberGenerator, Horses horses, Users users, Match match, Lap targetLap) {
        this.numberGenerator = numberGenerator;
        this.horses = horses;
        this.users = users;
        this.match = match;
        this.targetLap = targetLap;
        this.currLap = Lap.init();
    }

    public static Game init(NumberGenerator numberGenerator,
                            Horses horses,
                            Users users,
                            Match match,
                            Lap targetLap) {
        return new Game(numberGenerator, horses, users, match, targetLap);
    }

    public void start() {
        if (!hasMoreLap()) {
            throw new IllegalStateException("이미 모든 바퀴를 진행했습니다.");
        }

        currLap = currLap.increase();
        horses.run(numberGenerator);
    }

    public boolean hasMoreLap() {
        return !targetLap.equals(currLap);
    }

    public Winners winners() {
        if (hasMoreLap()) {
            throw new IllegalStateException("아직 게임이 종료되지 않았습니다.");
        }

        return new Winners(horses, users, match);
    }

    public Horses getHorses() {
        return horses;
    }
}
