package com.nhnacademy.jpa.board.repository;

import com.nhnacademy.jpa.board.Repository.LikeRepository;
import com.nhnacademy.jpa.board.Repository.PostRepository;
import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.config.RootConfig;
import com.nhnacademy.jpa.board.config.WebConfig;
import com.nhnacademy.jpa.board.entity.Like;
import com.nhnacademy.jpa.board.entity.Post;
import com.nhnacademy.jpa.board.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class LikeRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Test
    void test(){
        Like like = likeRepository.findById(new Like.Pk(1L, 4L)).get();

        assertThat(like.getLikeCount()).isEqualTo(1);
    }
}
