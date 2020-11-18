package com.example.demo.dao;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserDAO {
    User getUserByID(Integer id);
    int addUser(User user);

    List<User> getAllUsers();
}
