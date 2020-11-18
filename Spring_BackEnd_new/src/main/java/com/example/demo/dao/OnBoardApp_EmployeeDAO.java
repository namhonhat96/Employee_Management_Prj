package com.example.demo.dao;

public interface OnBoardApp_EmployeeDAO {
    void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate,
                     String visaEndDate, String driverLisence, String driver_exp);
}
