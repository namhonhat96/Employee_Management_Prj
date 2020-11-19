package com.example.demo.dao;

import com.example.demo.pojo.Test;

import java.util.List;

public interface TestDAO {
    int addTest(int ID, String name);
    int updateTest(int ID, String name);
    Test getTestByID(Integer id);
    List<Test> getAllTests();


}
