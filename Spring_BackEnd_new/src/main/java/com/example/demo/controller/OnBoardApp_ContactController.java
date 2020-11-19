package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.service.OnBoardApp_ContactService;
import com.example.demo.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class OnBoardApp_ContactController {

    private OnBoardApp_ContactService onBoardApp_contactService;

    @Autowired
    public void setContactService(OnBoardApp_ContactService onBoardApp_contactService) {
        this.onBoardApp_contactService = onBoardApp_contactService;
    }

    @GetMapping("/onboard-contact/{id}")
    @ResponseBody
    public OnBoardApp_Contact getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_contactService.getContactByID(ID);
    }

    @PostMapping("/onboard-contact")
    void addContact(@RequestBody OnBoardApp_Contact contact) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_contactService.addContact(ID, contact.getPersonID(), contact.getRelationship(), contact.getIsReference(), contact.getIsEmergency());
    }
}
