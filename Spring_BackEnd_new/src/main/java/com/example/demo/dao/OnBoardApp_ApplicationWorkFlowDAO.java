package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;

import java.util.List;

public interface OnBoardApp_ApplicationWorkFlowDAO {
    void addApplicationWorkFlow(int ID, int employeeID, String type);
    void updateApplicationWorkFlow(int ID, int employeeID, String type);
    OnBoardApp_ApplicationWorkFlow getApplicationWorkFlowByID(Integer id);
    List<OnBoardApp_ApplicationWorkFlow> getAllApplicationWorkFlows();
}
