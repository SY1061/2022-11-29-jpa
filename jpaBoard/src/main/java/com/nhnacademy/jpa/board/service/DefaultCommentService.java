package com.nhnacademy.jpa.board.service;

import com.nhnacademy.jpa.board.Repository.CommentRepository;
import com.nhnacademy.jpa.board.Repository.PostRepository;
import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.entity.Comment;
import com.nhnacademy.jpa.board.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCommentService implements CommentService{
    private final UserRepository userRepository;

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    List<CommentDto> commentDtos = new ArrayList<>();

    public DefaultCommentService(UserRepository userRepository,
                                 PostRepository postRepository, CommentRepository commentRepository){
        this.userRepository = userRepository;
        this.postRepository= postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getComment(long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public CommentDto getCommentDto(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        String username = userRepository.findById(String.valueOf(comment.getUser().getId())).get().getUsername();
        CommentDto commentDto = new CommentDto(comment.getId(), comment.getUser().getId(), comment.getPost().getId(),
                username, comment.getContent(), comment.getTimestamp());
        return commentDto;
    }

    @Override
    public List<Comment> getAllPosts() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentDto> getAllPostsDto() {
        List<Comment> allComments = commentRepository.findAll();
        for(Comment comment : allComments){
            String username = userRepository.findById(String.valueOf(comment.getUser().getId())).get().getUsername();
            CommentDto commentDto = new CommentDto(comment.getId(), comment.getUser().getId(), comment.getPost().getId(),
                    username, comment.getContent(), comment.getTimestamp());
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
