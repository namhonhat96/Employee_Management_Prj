package com.namho.book_projc.dao.impl;

import com.namho.book_projc.dao.AbstractHibernateDAO;
import com.namho.book_projc.dao.UserDAO;
import com.namho.book_projc.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAOImpl")
public class UserDAOImpl extends AbstractHibernateDAO<User> implements UserDAO
{
    public UserDAOImpl()
    {
        setClazz(User.class);
    }

    @Override
    public User getUserByID(Integer id) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
