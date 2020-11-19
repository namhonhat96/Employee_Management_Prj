package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_EmployeeDAO;
import com.example.demo.dao.OnBoardApp_VisaStatusDAO;
import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OnBoardApp_VisaStatusService {
    private OnBoardApp_VisaStatusDAO onBoardApp_visaStatusDAO;

    @Autowired
    public void setVisaStatusDAOImpl(OnBoardApp_VisaStatusDAO onBoardApp_visaStatusDAO){
        this.onBoardApp_visaStatusDAO = onBoardApp_visaStatusDAO;
    }

    @Transactional
    public void addVisaStatus(int ID, String visaType,String active, String modificationDate, String createUser){
        this.onBoardApp_visaStatusDAO.addVisaStatus(ID,visaType,active, modificationDate,createUser);
    }

    @Transactional
    public OnBoardApp_VisaStatus getVisaStatusByID(Integer id)
    {
        return this.onBoardApp_visaStatusDAO.getVisaStatusByID(id);
    }

    @Transactional
    public void updateVisaStatus(int ID, String visaType,String active, String modificationDate, String createUser){
        this.onBoardApp_visaStatusDAO.updateVisaStatus(ID,visaType,active, modificationDate,createUser);
    }
}
