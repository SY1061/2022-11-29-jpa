package com.nhnacademy.jpa.board.service;

import com.nhnacademy.jpa.board.entity.Post;
import com.nhnacademy.jpa.board.dto.PostDto;

import java.util.List;

public interface PostService {
    Post getPost(long id);

    PostDto getPostDto(long id);

    List<Post> getAllPosts();

    List<PostDto> getAllPostsDto();

    void increaseCommentCount(Long id);

    Post insertPost(Post post);

    Post updatePost(Post post);

    void deletePost(long id);
}
