package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Test;
import com.example.demo.pojo.User;
import com.example.demo.security.CookieUtil;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(Model model)
    {
        model.addAttribute("test", new Test());
        return "add_test";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse, String username, String password,
                        String redirect, Model model)
    {
        Map<String, String> userMap = new HashMap<>();
        List<User> userList = userService.getAllUsers();
        for(int i = 0; i < userList.size(); i++)
        {
            System.out.println("Database User value: " + userList.get(i).getUserName());
            System.out.println("Database Password value: " + userList.get(i).getPassword());
            userMap.put(userList.get(i).getUserName(),
                    userList.get(i).getPassword());
        }

        if(userMap.containsKey(username) && userMap.get(username).equals(password))
        {
            System.out.println("User value: " + username);
            System.out.println("Password value: " + password);
            String token = JwtUtil.generateToken(Constant.SIGNING_KEY, username
            );
            CookieUtil.create(httpServletResponse, Constant.JWT_TOKEN_COOKIE_NAME, token, false,
                    -1, "localhost");

            return "loginsuccess";
        }
        else
        {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

    @PostMapping("/onboard-user")
    void addVisaStatus(@RequestBody User user) {
        Random random = new Random();
        int ID = random.nextInt();
        this.userService.addUser(ID, user.getUserName(),user.getEmail(), user.getPassword(),user.getPersonID());
    }

    @PostMapping("/onboard-user/update/{id}")
    void updateUser(@RequestBody User user, @PathVariable("id") Integer ID) {
        this.userService.updateUser(ID,user.getUserName(),user.getEmail(), user.getPassword(),user.getPersonID());
    }

    @GetMapping("/onboard-user/list")
    public List<User> getOnBoardApp_VisaStatusList(){
        List<User> userList = this.userService.getAllUsers();
        return userList;
    }

    @GetMapping("/onboard-user/{id}")
    @ResponseBody
    public User getUserByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.userService.getUserByID(ID);
    }

}
