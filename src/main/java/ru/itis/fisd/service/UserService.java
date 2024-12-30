package ru.itis.fisd.service;

import ru.itis.fisd.model.UserEntity;
import ru.itis.fisd.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void save(UserEntity user) {
        userRepository.save(user);
    }

}
