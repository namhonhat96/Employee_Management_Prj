package com.example.demo.dao;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserDAO {

    void addUser(int ID, String username, String email, String password, int personID);
    void updateUser(int ID, String username, String email, String password, int personID);
    User getUserByID(Integer id);
    List<User> getAllUsers();
}
