package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.service.OnBoardApp_PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OnBoardApp_PersonController {
    private OnBoardApp_PersonService onBoardApp_personService;

    @Autowired
    public void setPersonService(OnBoardApp_PersonService onBoardApp_personService) {
        this.onBoardApp_personService = onBoardApp_personService;
    }

    @PostMapping("/onboard-person")
    void addUser(@RequestBody OnBoardApp_Person person) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_personService.addPerson(ID,person.getFirstname(),person.getLastname(),
                person.getMiddlename(),person.getEmail(),person.getCellphone(),person.getAlternatephone(),
                person.getGender(),person.getSSN(),person.getDOB());
    }
}
