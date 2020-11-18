package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
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
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public int addUser(User user) {
        getCurrentSession().save(user);
        return 1;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "from User";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
