package com.example.demo.service;

import com.example.demo.dao.TestDAO;
import com.example.demo.pojo.Test;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TestService {
    public TestDAO testDAO;

    @Autowired
    public void setTestDAOImpl(TestDAO testDAO)
    {
        this.testDAO = testDAO;
    }

    @Transactional
    public List<Test> getAllTests()
    {
        return this.testDAO.getAllTests();
    }

    @Transactional
    public int addTest(int ID, String name)
    {
        return this.testDAO.addTest(ID, name);
    }

    @Transactional
    public Test getTestByID(Integer id)
    {
        return this.testDAO.getTestByID(id);
    }

    @Transactional
    public int updateTest(int ID, String name){
        System.out.print("service called");
        return this.testDAO.updateTest(ID,name);
    }

}
