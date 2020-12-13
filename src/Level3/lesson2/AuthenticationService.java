package ru.geekbrains.prev;

public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User doAuth(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
