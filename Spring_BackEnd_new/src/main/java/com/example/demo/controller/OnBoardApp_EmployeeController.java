package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_EmployeeController {
    private OnBoardApp_EmployeeService onBoardApp_employeeService;

    @Autowired
    public void setEmployeeService(OnBoardApp_EmployeeService onBoardApp_employeeService) {
        this.onBoardApp_employeeService = onBoardApp_employeeService;
    }

    @RequestMapping(value = "/onboard-employee", method = RequestMethod.POST)
    ResponseEntity<?> addEmployee(@RequestBody OnBoardApp_Employee person) {
        onBoardApp_employeeService.addEmployee(person.getID(),person.getPersonID(),person.getCar(),
                person.getVisaID(),person.getVisaStartDate(),person.getVisaEndDate(),person.getDriverLisence(),
                person.getDriver_exp());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-employee/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?>  updateEmployee(@RequestBody OnBoardApp_Employee person, @PathVariable("id") Integer ID) {
        this.onBoardApp_employeeService.updateEmployee(ID, person.getPersonID(),person.getTitle(), person.getManagerID(), person.getStartDate(),
                person.getEndDate(), person.getAvartar(), person.getCar(),
                person.getVisaID(), person.getVisaStartDate(), person.getVisaEndDate(),
                person.getDriverLisence(), person.getDriver_exp());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-employee/list", method = RequestMethod.GET)
    public List<OnBoardApp_Employee> getAllEmployees(){
        return this.onBoardApp_employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/onboard-employee/{id}", method = RequestMethod.GET)
    public OnBoardApp_Employee getEmployeeByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_employeeService.getEmployeeByID(ID);
    }

    @RequestMapping(value = "/onboard-employee/list/{id}", method = RequestMethod.GET)
    public List<OnBoardApp_Employee> getEmployeeByHouseID(@PathVariable("id") Integer ID) {
        return this.onBoardApp_employeeService.getEmployeeByHouseID(ID);
    }
}
