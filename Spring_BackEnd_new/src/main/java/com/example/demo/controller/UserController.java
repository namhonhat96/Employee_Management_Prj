package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.pojo.JwtRequest;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Test;
import com.example.demo.pojo.User;
import com.example.demo.security.CookieUtil;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
@CrossOrigin()
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> login(HttpServletResponse httpServletResponse, @RequestBody User authenticationRequest)
    {
            String username = authenticationRequest.getUsername();
            String password = authenticationRequest.getPassword();
            System.out.println("Username: " + username);
            System.out.println("Password value: " + password);
            Map<String, String> userMap = new HashMap<>();
            List<User> userList = userService.getAllUsers();
            for(int i = 0; i < userList.size(); i++)
            {
                userMap.put(userList.get(i).getUsername(),
                        userList.get(i).getPassword());
            }
            if(userMap.containsKey(username) && userMap.get(username).equals(password))
            {
                String token = JwtUtil.generateToken(Constant.SIGNING_KEY, username
                );
                CookieUtil.create(httpServletResponse, Constant.JWT_TOKEN_COOKIE_NAME, token, false,
                        -1, "localhost");
                return ResponseEntity.ok(new JwtResponse(token));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @RequestMapping(value = "/onboard-user", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        Random random = new Random();
        int ID = random.nextInt(1000);
        int personID = random.nextInt(1000);
        this.userService.addUser(ID, user.getUsername(),user.getEmail(), user.getPassword(),personID);
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-user/update/{id}", method = RequestMethod.POST)
    void updateUser(@RequestBody User user, @PathVariable("id") Integer ID) {
        this.userService.updateUser(ID,user.getUsername(),user.getEmail(), user.getPassword(),user.getPersonID());
    }

    @RequestMapping(value = "/onboard-user/list", method = RequestMethod.GET)
    public List<User> getOnBoardApp_VisaStatusList(){
        List<User> userList = this.userService.getAllUsers();
        return userList;
    }

    @RequestMapping(value = "/onboard-user/{id}", method = RequestMethod.GET)
    public User getUserByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.userService.getUserByID(ID);
    }

}
