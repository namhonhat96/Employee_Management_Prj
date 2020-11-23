package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;

import com.example.demo.dao.TestDAO;
import com.example.demo.pojo.Test;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TestDAOImpl")
public class TestDAOImpl extends AbstractHibernateDAO<Test> implements TestDAO {

    public TestDAOImpl()
    {
        setClazz(Test.class);
    }

    @Override
    public int addTest(int ID, String name) {
        Test test = new Test(ID, name);
        getCurrentSession().save(test);
        return 1;
    }

    @Override
    public int updateTest(int ID, String name) {
        Test test = getTestByID(ID);
        test.setName(name);
        getCurrentSession().update(test);
        return 1;
    }

    @Override
    public Test getTestByID(Integer id) {
        return getCurrentSession().get(Test.class, id);
    }

    @Override
    public List<Test> getAllTests() {
        String sql = "from Test";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
