package com.nhnacademy.jpa.board.controller;

import com.nhnacademy.jpa.board.service.PostService;
import com.nhnacademy.jpa.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private final UserService userService;

    private final PostService postService;

    public LoginController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping(value = {"/", "/login"})
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        Model model) {
        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
            return "select";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (userService.matches(id, pwd)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            modelMap.put("id", session.getId());
            session.setAttribute("loginId", userService.getUser(id).getId());
            session.setAttribute("PostRepositoryList", postService.getAllPostsDto());
            session.setAttribute("loginUsername", userService.getUser(id).getUsername());
            return "select";
        } else {
            return "login";
        }
    }
}
