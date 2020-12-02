package Level2.lesson7.auth;

import Level2.lesson7.entity.User;

import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}
