package com.nhnacademy.jpa.board.service;

import com.nhnacademy.jpa.board.Repository.PostRepository;
import com.nhnacademy.jpa.board.Repository.UserRepository;
import com.nhnacademy.jpa.board.entity.Post;
import com.nhnacademy.jpa.board.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPostService implements PostService{
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    List<PostDto> postDtos = new ArrayList<>();

    public DefaultPostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post getPost(long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public PostDto getPostDto(long id) {
        Post post = postRepository.findById(id).orElse(null);
        String username = userRepository.findById(String.valueOf(post.getUser().getId())).get().getUsername();
        PostDto postDto = new PostDto(post.getId(), post.getTitle(), username, post.getContent(), post.getTimestamp(),
                post.getModifyTimestamp(), post.getCommentCount());
        return postDto;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<PostDto> getAllPostsDto() {
        List<Post> allPosts = getAllPosts();
        for(Post post : allPosts){
            String username = userRepository.findById(String.valueOf(post.getUser().getId())).get().getUsername();
            PostDto postDto = new PostDto(post.getId(), post.getTitle(), username, post.getContent(), post.getTimestamp(),
                    post.getModifyTimestamp(), post.getCommentCount());
            postDtos.add(postDto);
        }
        return postDtos;
    }

    @Override
    public void increaseCommentCount(Long id) {
        Long commentCount = postRepository.findById(id).get().getCommentCount();
        postRepository.findById(id).get().setCommentCount(++commentCount);
    }

    @Transactional
    @Override
    public Post insertPost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post updatePost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
