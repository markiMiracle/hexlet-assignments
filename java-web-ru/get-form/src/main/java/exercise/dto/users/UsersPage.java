package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class UsersPage {
    public List<User> users;
    public String term;

    public UsersPage(List<User> users) {
        this.users = users;
    }
}
