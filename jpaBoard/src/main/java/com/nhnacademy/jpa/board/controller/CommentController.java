//package com.nhnacademy.jpa.board.controller;
//
//import com.nhnacademy.jpa.board.entity.Comment;
//import com.nhnacademy.jpa.board.service.CommentService;
//import com.nhnacademy.jpa.board.service.PostService;
//import com.nhnacademy.jpa.board.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDateTime;
//
//@Controller
//public class CommentController {
//    private  final UserService userService;
//
//    private  final PostService postService;
//
//    private final CommentService commentService;
//
//    public CommentController(UserService userService, PostService postService,
//                             CommentService commentService){
//        this.userService = userService;
//        this.postService = postService;
//        this.commentService = commentService;
//    }
//
//    @PostMapping("/comment/register/{postId}")
//    public String getComment(@PathVariable("postId") Long id,
//                             @RequestParam("commentContent") String content,HttpSession session){
//        Object loginId = session.getAttribute("loginId");
//        Comment comment = new Comment(userService.getUser((String) loginId) ,postService.getPost(id),
//                content, LocalDateTime.now(), null);
//        postService.increaseCommentCount(id);
//        return "view";
//    }
//}
