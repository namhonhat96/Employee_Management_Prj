package com.beaconfire.work_mgt_project.dao;

import com.beaconfire.work_mgt_project.domain.Test;

import java.util.List;

public interface TestDAO {
    public void addTest(int ID, String name);
    List<Test> getListInfo();
}

