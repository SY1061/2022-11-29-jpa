package com.nhnacademy.jpa.board.repository;

import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.config.RootConfig;
import com.nhnacademy.jpa.board.config.WebConfig;
import com.nhnacademy.jpa.board.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test(){
        List<User> users = userRepository.findByUsernameLike("sun%");
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    void test2(){
        User user = userRepository.findByUsername("sunny");
        assertThat(user.getPassword()).isEqualTo("1234");
    }

    @Test
    void test3(){
        boolean exist = userRepository.existsByUsernameAndPassword("sunny", "1234");
        assertThat(exist).isTrue();
    }
}
