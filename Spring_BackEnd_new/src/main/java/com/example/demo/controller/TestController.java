package com.example.demo.controller;

import com.example.demo.pojo.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class TestController {
    private TestService testService;

    @Autowired
    public void setTestService(TestService testService)
    {
        this.testService = testService;
    }

    @RequestMapping(value = "/addtest", method = RequestMethod.POST)
    public ResponseEntity<?> addTest(@RequestBody Test test) {
        Random random = new Random();
        int ID = random.nextInt(10000);
        testService.addTest(ID, test.getName());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/listtest",method = RequestMethod.GET)
    public  List<Test> getTest() {
        List<Test> testList = testService.getAllTests();
        System.out.println("List Test is called");
        return testList;
    }

    @RequestMapping(value = "/updatetest/{id}",method = RequestMethod.POST)
    public ResponseEntity<?>  updateTest(@PathVariable("id") Integer id, @RequestBody Test test) {
        System.out.println("Update Test is called");
        testService.updateTest(id,test.getName());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/testID/{id}",method = RequestMethod.GET)
    public Test getTestID(@PathVariable("id") Integer id)
    {
        Test test = testService.getTestByID(id);
        return test;
    }

}
