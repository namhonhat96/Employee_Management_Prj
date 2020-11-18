package com.namho.book_projc.service;

import com.namho.book_projc.dao.UserDAO;
import com.namho.book_projc.pojo.User;
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
    public int addUser(User user)
    {
        return this.userDAOImpl.addUser(user);
    }

    @Transactional
    public User getUserByID(Integer id)
    {
        return this.userDAOImpl.getUserByID(id);
    }
}
