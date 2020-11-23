package com.example.demo.service;


import com.example.demo.dao.OnBoardApp_ApplicationWorkFlowDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OnBoardApp_ApplicationWorkFlowService {
    private OnBoardApp_ApplicationWorkFlowDAO onBoardApp_applicationWorkFlowDAO;

    @Autowired
    public void setOnBoardApp_applicationWorkFlowDAODAO(OnBoardApp_ApplicationWorkFlowDAO onBoardApp_applicationWorkFlowDAO){
        this.onBoardApp_applicationWorkFlowDAO = onBoardApp_applicationWorkFlowDAO;
    }

    @Transactional
    public void addApplicationWorkFlow(int ID, int employeeID, String type){
        this.onBoardApp_applicationWorkFlowDAO.addApplicationWorkFlow(ID,employeeID,type);
    }

    @Transactional
    public void updateApplicationWorkFlow(int ID, int employeeID, String type){
        this.onBoardApp_applicationWorkFlowDAO.updateApplicationWorkFlow(ID,employeeID,type);
    }

    @Transactional
    public OnBoardApp_ApplicationWorkFlow getApplicationWorkFlowByID(Integer id)
    {
        return this.onBoardApp_applicationWorkFlowDAO.getApplicationWorkFlowByID(id);
    }

    @Transactional
    public List<OnBoardApp_ApplicationWorkFlow> getAllApplicationWorkFlows(){
        return this.onBoardApp_applicationWorkFlowDAO.getAllApplicationWorkFlows();
    }
}
