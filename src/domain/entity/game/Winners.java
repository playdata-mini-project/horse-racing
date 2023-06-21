package domain.entity.game;

import domain.entity.horse.Horse;
import domain.entity.horse.Horses;
import domain.entity.user.User;
import domain.entity.user.Users;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winners {

    // 우승한 말과 유저
    private final List<Horse> horses;
    private final List<User> users;

    public Winners(Horses horses, Users users, Match match) {
        this.horses = decideWinningHorses(horses.getHorses());
        this.users = decideWinningUsers(this.horses, users.getUsers(), match);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public List<User> getUsers() {
        return users;
    }

    private List<Horse> decideWinningHorses(List<Horse> horses) {
        Horse winner = horses.stream()
                .max(Comparator.comparing(Horse::getPosition))
                .orElseThrow(IllegalArgumentException::new);

        return horses.stream()
                .filter(horse -> horse.isSamePosition(winner))
                .collect(Collectors.toList());
    }

    private List<User> decideWinningUsers(List<Horse> horses, List<User> users, Match match) {
        List<String> winningHorseNames = horses.stream()
                .map(Horse::getName)
                .collect(Collectors.toList());

        return match.getMatchMap().entrySet().stream()
                .filter(entry -> winningHorseNames.contains(entry.getKey().getName()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}