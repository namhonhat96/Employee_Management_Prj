package com.namho.book_projc.controller;

import com.namho.book_projc.constant.Constant;
import com.namho.book_projc.security.CookieUtil;
import com.namho.book_projc.security.JwtUtil;
import com.namho.book_projc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome()
    {
        return "index";
    }

    /*@PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse, String username, String password,
                        String redirect, Model model)
    {
        Map<String, String> userMap = new HashMap<>();
        for(int i = 0; i < userService.getAllUsers().size(); i++)
        {
            userMap.put(userService.getAllUsers().get(i).getUserName(),
                    userService.getAllUsers().get(i).getPassword());
        }
        userMap.put("admin", "admin");
        if(userMap.containsKey(username) && userMap.get(username).equals(password))
        {
            String token = JwtUtil.generateToken(Constant.SIGNING_KEY, username
            );
            CookieUtil.create(httpServletResponse, Constant.JWT_TOKEN_COOKIE_NAME, token, false,
                    -1, "localhost");

            return "redirect:" + redirect;
        }
        else
        {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }*/
}
