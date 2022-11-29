package com.nhnacademy.jpa.board.repository;

import com.nhnacademy.jpa.board.Repository.PostRepository;
import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.config.RootConfig;
import com.nhnacademy.jpa.board.config.WebConfig;
import com.nhnacademy.jpa.board.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class PostRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    void test(){
        Post post = postRepository.findById(1L).get();
        assertThat(post.getUser().getId()).isEqualTo(1L);
    }

    @Test
    void test2(){
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(10);
    }

    @Test
    void createPost(){
        Post post = new Post();
        post.setId(11L);
        post.setTitle("test11");
        post.setUser(userRepository.findByUsername("sunny"));
        post.setContent("test11");
        post.setCommentCount(0L);
        post.setTimestamp(LocalDateTime.now());

        postRepository.save(post);
        postRepository.flush();
    }

    @Test
    void updatePost(){
        Post post = new Post();
        post.setId(10L);
        post.setTitle("test11");
        post.setUser(userRepository.findByUsername("sunny"));
        post.setContent("test11");
        post.setCommentCount(0L);
        post.setTimestamp(LocalDateTime.now());

        postRepository.save(post);
        postRepository.flush();
    }

    @Test
    void deletePost(){
        postRepository.deleteById(10L);
        postRepository.flush();
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(9);
    }
}
