package com.nhnacademy.jpa.board.service;



import com.nhnacademy.jpa.board.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    List<User> getAllUsers();
    boolean matches(String id, String password);
}
