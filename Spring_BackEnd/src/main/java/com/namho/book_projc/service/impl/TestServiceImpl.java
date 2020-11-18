package com.namho.book_projc.service.impl;

import com.namho.book_projc.dao.TestDAO;
import com.namho.book_projc.domain.Test;
import com.namho.book_projc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private TestDAO testDAO;

    @Autowired
    public void setBookDAO(TestDAO testDAO){
        this.testDAO = testDAO;
    }


    @Override
    public List<Test> getAllTestInfo() {
        return testDAO.getTestInfo();
    }
}
