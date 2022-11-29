//package com.nhnacademy.jpa.board.controller;
//
//import com.nhnacademy.jpa.board.entity.Post;
//import com.nhnacademy.jpa.board.service.PostService;
//import com.nhnacademy.jpa.board.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDateTime;
//
//@Controller
//public class RegisterController {
//    private final UserService userService;
//    private final PostService postService;
//
//    public RegisterController(UserService userService, PostService postService){
//        this.userService = userService;
//        this.postService = postService;
//    }
//
//    @GetMapping("/register")
//    public String register(){
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String doRegister(
//            @RequestParam("title") String title,
//            @RequestParam("content") String content, HttpSession session){
//        Object loginId = session.getAttribute("loginId");
//        Post post = new Post(title, userService.getUser((String) loginId), null,
//                content, null, LocalDateTime.now(), null);
//        postService.insertPost(post);
//        session.setAttribute("PostRepositoryList", postService.getAllPostsDto());
//
//        return "select";
//    }
//
//
//}
