package com.nhnacademy.jpa.board.service;

import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean matches(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }
}
