package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository("userDAOImpl")
public class UserDAOImpl extends AbstractHibernateDAO<User> implements UserDAO
{
    public UserDAOImpl()
    {
        setClazz(User.class);
    }

    @Override
    public void addUser(int ID, String username, String email, String password, int personID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String createDate = dateFormat.format(date);
        String modificationDate = dateFormat.format(date);
        User user = new User(ID, username,email, password,personID, createDate, modificationDate);
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(int ID, String username, String email, String password, int personID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String modificationDate = dateFormat.format(date);
        User user = getUserByID(ID);
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPersonID(personID);
        user.setModificationDate(modificationDate);
        getCurrentSession().save(user);
    }

    @Override
    public User getUserByID(Integer id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "from User";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
