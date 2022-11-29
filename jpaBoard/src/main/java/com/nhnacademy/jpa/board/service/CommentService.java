package com.nhnacademy.jpa.board.service;

import com.nhnacademy.jpa.board.entity.Comment;
import com.nhnacademy.jpa.board.dto.CommentDto;

import java.util.List;

public interface CommentService {
    Comment getComment(long id);

    CommentDto getCommentDto(long id);

    List<Comment> getAllPosts();

    List<CommentDto> getAllPostsDto();

    void insertComment(Comment comment);

    void deleteComment(long id);
}
