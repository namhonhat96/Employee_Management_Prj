package com.beaconfire.work_mgt_project.service.impl;

import com.beaconfire.work_mgt_project.dao.TestDAO;
import com.beaconfire.work_mgt_project.domain.Test;
import com.beaconfire.work_mgt_project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private TestDAO testDAO;

    @Autowired
    public void setTestDAO(TestDAO testDAO){
        this.testDAO = testDAO;
    }

    @Override
    public List<Test> getAllTestingInfo() {
        return testDAO.getListInfo();
    }
}
