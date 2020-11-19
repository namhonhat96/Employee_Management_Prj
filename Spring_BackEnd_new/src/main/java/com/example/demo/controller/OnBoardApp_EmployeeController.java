package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class OnBoardApp_EmployeeController {
    private OnBoardApp_EmployeeService onBoardApp_employeeService;

    @Autowired
    public void setEmployeeService(OnBoardApp_EmployeeService onBoardApp_employeeService) {
        this.onBoardApp_employeeService = onBoardApp_employeeService;
    }

    @GetMapping("/onboard-employee/{id}")
    @ResponseBody
    public OnBoardApp_Employee getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_employeeService.getEmployeeByID(ID);
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
