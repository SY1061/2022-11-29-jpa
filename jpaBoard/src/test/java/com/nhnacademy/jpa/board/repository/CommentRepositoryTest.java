package com.nhnacademy.jpa.board.repository;

import com.nhnacademy.jpa.board.Repository.CommentRepository;
import com.nhnacademy.jpa.board.Repository.PostRepository;
import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.config.RootConfig;
import com.nhnacademy.jpa.board.config.WebConfig;
import com.nhnacademy.jpa.board.entity.Comment;
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
public class CommentRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void getComment(){
        Comment comment = commentRepository.findById(1L).get();
        assertThat(comment.getUser().getId()).isEqualTo(3L);
    }

    @Test
    void findAllComment(){
        List<Comment> comments = commentRepository.findAll();
        assertThat(comments.size()).isEqualTo(5);
    }

    @Test
    void createComment() {
        Comment comment = new Comment();
        comment.setId(6L);
        comment.setUser(userRepository.findByUsername("sun"));
        comment.setPost(postRepository.findById(3L).get());
        comment.setContent("댓글 추가");
        comment.setTimestamp(LocalDateTime.now());

        commentRepository.save(comment);
        commentRepository.flush();

        Comment newComment = commentRepository.findById(6L).get();
        assertThat(newComment.getUser().getId()).isEqualTo(2L);
    }

    @Test
    void updateComment(){
        Comment comment = new Comment();
        comment.setId(4L);
        comment.setUser(userRepository.findByUsername("sun"));
        comment.setPost(postRepository.findById(1L).get());
        comment.setContent("댓글 수정");
        comment.setTimestamp(LocalDateTime.now());

        commentRepository.save(comment);
        commentRepository.flush();
    }

    @Test
    void deleteComment(){
        commentRepository.deleteById(4L);

        List<Comment> comments = commentRepository.findAll();
        assertThat(comments.size()).isEqualTo(4);
    }
}
