package com.example.demo.dao;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserDAO {

    int addUser(User user);

    User getUserByID(Integer id);
    List<User> getAllUsers();
}
