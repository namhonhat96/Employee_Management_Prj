package com.namho.book_projc.controller;

import com.namho.book_projc.domain.OnBoardApp_Employee;
import com.namho.book_projc.service.OnBoardApp_EmployeeService;
import com.namho.book_projc.service.OnBoardApp_PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OnBoardApp_EmployeeController {
    private OnBoardApp_EmployeeService onBoardApp_employeeService;

    @Autowired
    public void OnBoardApp_PersonService(OnBoardApp_EmployeeService onBoardApp_employeeService) {
        this.onBoardApp_employeeService = onBoardApp_employeeService;
    }

    @PostMapping("/onboard-employee")
    void addUser(@RequestBody OnBoardApp_Employee person) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_employeeService.addEmployee(ID,person.getPersonID(),person.getCar(),
                person.getVisaID(),person.getVisaStartDate(),person.getVisaEndDate(),person.getDriverLisence(),
                person.getDriver_exp());
    }
}
