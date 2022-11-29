package com.nhnacademy.jpa.board.controller;

import com.nhnacademy.jpa.board.entity.Post;
import com.nhnacademy.jpa.board.entity.User;
import com.nhnacademy.jpa.board.service.CommentService;
import com.nhnacademy.jpa.board.service.PostService;
import com.nhnacademy.jpa.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class ViewController {
    private final UserService userService;

    private final PostService postService;

    private final CommentService commentService;

    public ViewController(UserService userService, PostService postService, CommentService commentService){
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/view/{postId}")
    public String view(@PathVariable("postId") Long id,
                       HttpSession session){
        session.setAttribute("post", postService.getPostDto(id));
        session.setAttribute("commentRepositoryList", commentService.getAllPostsDto());
        return "view";
    }

    @GetMapping("/update/{postId}")
    public String update(@PathVariable("postId") Long id){
        return "update";
    }

    @PostMapping("/update/{postId}")
    public String doUpdate(@PathVariable("postId") Long id,
                           @RequestParam("content") String content,
                           HttpSession session){
        Post post = postService.getPost(id);
        Object loginId = session.getAttribute("loginId");
        User user = userService.getUser((String) loginId);

        setPost(content, post, user);

        postService.updatePost(post);
        session.setAttribute("post", postService.getPostDto(id));
        return "view";
    }

    @GetMapping("/delete/{postId}")
    public String delete(@PathVariable("postId") Long id,
                         HttpSession session){
        postService.deletePost(id);
        session.setAttribute("PostRepositoryList", postService.getAllPostsDto());
        return "select";
    }

    private void setPost(String content, Post post, User user) {
        post.setModifyUser(user);
        post.setContent(content);
        post.setModifyTimestamp(LocalDateTime.now());
    }
}
