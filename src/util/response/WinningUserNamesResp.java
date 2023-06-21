package util.response;

import domain.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class WinningUserNamesResp {

    private final List<String> userNames;

    public WinningUserNamesResp(List<User> users) {
        this.userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<String> getUserNames() {
        return userNames;
    }
}
