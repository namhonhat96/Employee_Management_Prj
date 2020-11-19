package com.example.demo.service;


import com.example.demo.dao.OnBoardApp_ApplicationWorkFlowDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OnBoardApp_ApplicationWorkFlowService {
    private OnBoardApp_ApplicationWorkFlowDAO onBoardApp_applicationWorkFlowDAO;

    @Autowired
    public void setOnBoardApp_applicationWorkFlowDAODAO(OnBoardApp_ApplicationWorkFlowDAO onBoardApp_applicationWorkFlowDAO){
        this.onBoardApp_applicationWorkFlowDAO = onBoardApp_applicationWorkFlowDAO;
    }

    @Transactional
    void addApplicationWorkFlow(int ID, int employeeID, String createDate, String modificationDate, String type){
        this.onBoardApp_applicationWorkFlowDAO.addApplicationWorkFlow(ID,employeeID,createDate,modificationDate,type);
    }

    @Transactional
    public OnBoardApp_ApplicationWorkFlow getApplicationWorkFlowByID(Integer id)
    {
        return this.onBoardApp_applicationWorkFlowDAO.getApplicationWorkFlowByID(id);
    }
}
