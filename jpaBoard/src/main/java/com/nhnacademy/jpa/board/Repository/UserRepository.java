package com.nhnacademy.jpa.board.Repository;


import com.nhnacademy.jpa.board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUsernameLike(String username);
    boolean existsByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
