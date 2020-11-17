package com.beaconfire.work_mgt_project.controller;

import com.beaconfire.work_mgt_project.domain.Test;
import com.beaconfire.work_mgt_project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "index";
    }

    @GetMapping("/list-test")
    public String getBook(Model model) {
        List<Test> testList = testService.getAllTestingInfo();
        model.addAttribute("testList", testList);
        return "test_list";
    }

}
