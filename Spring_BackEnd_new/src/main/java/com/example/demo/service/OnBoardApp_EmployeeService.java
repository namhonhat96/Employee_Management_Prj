package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_EmployeeDAO;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OnBoardApp_EmployeeService{
    private OnBoardApp_EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(OnBoardApp_EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate, String visaEndDate, String driverLisence, String driver_exp) {
        this.employeeDAO.addEmployee(ID,personID,car, visaID,visaStartDate,visaEndDate,driverLisence,driver_exp);
    }

    @Transactional
    public OnBoardApp_Employee getEmployeeByID(Integer id)
    {
        return this.employeeDAO.getEmployeeByID(id);
    }
}
