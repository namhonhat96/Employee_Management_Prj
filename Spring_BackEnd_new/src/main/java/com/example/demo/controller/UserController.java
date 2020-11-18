package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.pojo.User;
import com.example.demo.security.CookieUtil;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse, String username, String password,
                        String redirect, Model model)
    {
        Map<String, String> userMap = new HashMap<>();
        List<User> userList = userService.getAllUsers();
        //userList.add(new User(1, "admin@gmail.com", "a@gmail.com", "admin", 1, "1/1/2020", "1/1/2020"));
        for(int i = 0; i < userList.size(); i++)
        {
            System.out.println("User value: " + userList.get(i).getUserName());
            System.out.println("Password value: " + userList.get(i).getPassword());
            userMap.put(userList.get(i).getUserName(),
                    userList.get(i).getPassword());
        }
        //userMap.put("admin", "admin");

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
    }
}
