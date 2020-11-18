package com.namho.book_projc.controller;

import com.namho.book_projc.domain.Test;
import com.namho.book_projc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class TestController {

    private TestService testService;

    @Autowired
    public void setContactService(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/list-test")
    public String getBook(Model model) {
        List<Test> testList = testService.getAllTestInfo();
        System.out.println(testList.get(0).getID());
        model.addAttribute("testList", testList);
        return "test_list";
    }
}
