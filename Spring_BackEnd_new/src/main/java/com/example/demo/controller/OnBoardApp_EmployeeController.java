package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class OnBoardApp_EmployeeController {
    private OnBoardApp_EmployeeService onBoardApp_employeeService;

    @Autowired
    public void setEmployeeService(OnBoardApp_EmployeeService onBoardApp_employeeService) {
        this.onBoardApp_employeeService = onBoardApp_employeeService;
    }

    @PostMapping("/onboard-employee")
    void addEmployee(@RequestBody OnBoardApp_Employee person) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_employeeService.addEmployee(ID,person.getPersonID(),person.getCar(),
                person.getVisaID(),person.getVisaStartDate(),person.getVisaEndDate(),person.getDriverLisence(),
                person.getDriver_exp());
    }

    @PostMapping("/onboard-employee/update/{id}")
    void updateEmployee(@RequestBody OnBoardApp_Employee person, @PathVariable("id") Integer ID) {
        this.onBoardApp_employeeService.updateEmployee(ID, person.getPersonID(),person.getCar(),
                person.getVisaID(), person.getVisaStartDate(), person.getVisaEndDate(),
                person.getDriverLisence(), person.getDriver_exp());
    }

    @GetMapping("/onboard-employee/list")
    public List<OnBoardApp_Employee> getOnBoardApp_EmployeeList(){
        List<OnBoardApp_Employee> OnBoardApp_Employeelist = this.onBoardApp_employeeService.getAllEmployees();
        return OnBoardApp_Employeelist;
    }

    @GetMapping("/onboard-employee/{id}")
    @ResponseBody
    public OnBoardApp_Employee getEmployeeByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_employeeService.getEmployeeByID(ID);
    }
}
