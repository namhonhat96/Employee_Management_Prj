package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.service.OnBoardApp_PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_PersonController {
    private OnBoardApp_PersonService onBoardApp_personService;

    @Autowired
    public void setPersonService(OnBoardApp_PersonService onBoardApp_personService) {
        this.onBoardApp_personService = onBoardApp_personService;
    }

    @RequestMapping(value = "/onboard-person", method = RequestMethod.POST)
    ResponseEntity<?> addPerson(@RequestBody OnBoardApp_Person person) {
        System.out.println(person.getFirstname());
        Random random = new Random();
        int ID = random.nextInt(1000);
        onBoardApp_personService.addPerson(ID,person.getFirstname(),person.getLastname(),
                person.getMiddlename(),person.getEmail(),person.getCellphone(),person.getAlternatephone(),
                person.getGender(),person.getSSN(),person.getDOB());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-person/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updatePerson(@RequestBody OnBoardApp_Person person, @PathVariable("id") Integer ID) {
        this.onBoardApp_personService.updatePerson(ID, person.getFirstname(),person.getLastname(),
                person.getMiddlename(),person.getEmail(),person.getCellphone(), person.getAlternatephone(),
                person.getGender(), person.getSSN(), person.getDOB());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-person/list", method = RequestMethod.GET)
    public List<OnBoardApp_Person> getAllPersons(){
        return this.onBoardApp_personService.getAllPersons();
    }

    @RequestMapping(value = "/onboard-person/{id}", method = RequestMethod.GET)
    public OnBoardApp_Person getPersonByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_personService.getPersonByID(ID);
    }
}
