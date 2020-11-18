package com.namho.book_projc.dao;

import com.namho.book_projc.pojo.User;

import java.util.List;

public interface UserDAO {
    User getUserByID(Integer id);
    int addUser(User user);

    List<User> getAllUsers();
}
