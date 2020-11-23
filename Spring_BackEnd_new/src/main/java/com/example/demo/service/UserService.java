package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    public UserDAO userDAOImpl;

    @Autowired
    public void setUserDAOImpl(UserDAO userDAOImpl)
    {
        this.userDAOImpl = userDAOImpl;
    }

    @Transactional
    public List<User> getAllUsers()
    {
        return this.userDAOImpl.getAllUsers();
    }

    @Transactional
    public void addUser(int ID, String username, String email, String password, int personID)
    {
        this.userDAOImpl.addUser(ID, username,email,password, personID);
    }

    @Transactional
    public void updateUser(int ID, String username, String email, String password, int personID)
    {
        this.userDAOImpl.updateUser(ID, username,email,password, personID);
    }

    @Transactional
    public User getUserByID(Integer id)
    {
        return this.userDAOImpl.getUserByID(id);
    }


}
