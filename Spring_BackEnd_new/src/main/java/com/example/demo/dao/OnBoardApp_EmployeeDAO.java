package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_Person;

import java.util.List;

public interface OnBoardApp_EmployeeDAO {
    void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate,
                     String visaEndDate, String driverLisence, String driver_exp);

    void updateEmployee(int ID, int personID, String title, int managerID, String startDate, String endDate, String avartar, String car, int visaID, String visaStartDate,
                     String visaEndDate, String driverLisence, String driver_exp);
    OnBoardApp_Employee getEmployeeByID(Integer id);
    List<OnBoardApp_Employee> getAllEmployees();

}
