package com.example.demo.controller;

import com.example.demo.pojo.Test;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/addtest")
    public String getAddTest(Model model) {
        model.addAttribute("test", new Test());
        return "add_test";
    }

    @PostMapping("/addtest")
    public String addBook(Model model) {
        Random random = new Random();
        int ID = random.nextInt(10000);
        testService.addTest(ID, "random");
        model.addAttribute("newTest", new Test());
        return "success_test";
    }

    @GetMapping("/listtest")
    public String getTest(Model model) {
        List<Test> testList = testService.getAllTests();
        model.addAttribute("testList", testList);
        return "list_test";
    }

    @GetMapping("/updatetest")
    public String welcome(Model model)
    {
        model.addAttribute("test", new Test());
        return "update_test";
    }


    @PostMapping("/updatetest/{id}")
    public String updateTest(@PathVariable("id") Integer id, Model model, @ModelAttribute("test")Test test) {
        //Update test to the database
        String name = "updated";
        testService.updateTest(id,name);
        return "success_test";
    }

    @GetMapping("/testID/{id}")
    public String getTestID(@PathVariable("id") Integer id, Model model)
    {
        Test test = testService.getTestByID(id);
        model.addAttribute("test", test);
        return "test_id_result";
    }

}
