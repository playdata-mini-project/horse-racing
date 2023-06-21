package domain.entity.game;

import domain.entity.horse.Horse;
import domain.entity.horse.Horses;
import domain.entity.user.Users;
import domain.entity.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match {

    private static final int INIT_CAPACITY = 5;
    private final Map<Horse, User> matchMap = new HashMap<>(INIT_CAPACITY);

    private Match(List<Horse> horses, List<User> users) {
        for (int i = 0; i < INIT_CAPACITY; i++) {
            matchMap.put(horses.get(i), users.get(i));
        }
    }

    public static Match matching(Horses horses, Users users) {
        return new Match(horses.getHorses(), users.getUsers());
    }

    public Map<Horse, User> getMatchMap() {
        return matchMap;
    }
}
