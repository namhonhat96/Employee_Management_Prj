package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_EmployeeDAO;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public List<OnBoardApp_Employee> getAllEmployees(){
        return this.employeeDAO.getAllEmployees();
    }

    @Transactional
    public void updateEmployee(int ID, int personID, String title, int managerID, String startDate, String endDate, String avartar, String car, int visaID, String visaStartDate,
                                String visaEndDate, String driverLisence, String driver_exp){
        this.employeeDAO.updateEmployee(ID, personID,title, managerID, startDate, endDate, avartar, car,visaID,visaStartDate,visaEndDate,driverLisence,driver_exp);
    }
}
