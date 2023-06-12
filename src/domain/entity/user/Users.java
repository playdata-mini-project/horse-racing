package domain.entity.user;


import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final int SIZE = 5;
    private final List<User> users;

    public Users(List<String> userNames) {
        if (userNames.size() != SIZE) {
            throw new IllegalArgumentException("유저는 5명 존재해야 합니다.");
        }

        this.users = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return users;
    }
}
