package com.namho.book_projc.service.impl;

import com.namho.book_projc.dao.OnBoardApp_EmployeeDAO;
import com.namho.book_projc.dao.OnBoardApp_PersonDAO;
import com.namho.book_projc.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnBoardApp_EmployeeServiceImpl implements OnBoardApp_EmployeeService {
    private OnBoardApp_EmployeeDAO employeeDAO;

    @Autowired
    public void setTestDAO(OnBoardApp_EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate, String visaEndDate, String driverLisence, String driver_exp) {
        employeeDAO.addEmployee(ID,personID,car, visaID,visaStartDate,visaEndDate,driverLisence,driver_exp);
    }
}
