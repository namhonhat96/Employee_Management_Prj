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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    private TestService testService;

    @Autowired
    public void setContactService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/do-test")
    public List<Test> getBook() {
        List<Test> testList = testService.getAllTestInfo();
        return testList;
    }

    @PostMapping("/do-test")
    void addUser(@RequestBody Test test) {
        testService.save(test);
    }

}
