package com.namho.book_projc.controller;

import com.namho.book_projc.domain.OnBoardApp_Person;
import com.namho.book_projc.domain.Test;
import com.namho.book_projc.service.OnBoardApp_PersonService;
import com.namho.book_projc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class OnBoardApp_PersonController {
    private OnBoardApp_PersonService onBoardApp_personService;

    @Autowired
    public void OnBoardApp_PersonService(OnBoardApp_PersonService onBoardApp_personService) {
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
