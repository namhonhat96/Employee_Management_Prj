package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.service.OnBoardApp_ContactService;
import com.example.demo.service.OnBoardApp_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_ContactController {

    private OnBoardApp_ContactService onBoardApp_contactService;

    @Autowired
    public void setContactService(OnBoardApp_ContactService onBoardApp_contactService) {
        this.onBoardApp_contactService = onBoardApp_contactService;
    }

    @RequestMapping(value = "/onboard-contact", method = RequestMethod.POST)
    ResponseEntity<?> addContact(@RequestBody OnBoardApp_Contact contact) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_contactService.addContact(ID, contact.getPersonID(), contact.getRelationship(), contact.getIsReference(), contact.getIsEmergency());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-contact/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateContact(@RequestBody OnBoardApp_Contact contact, @PathVariable("id") Integer ID) {
        onBoardApp_contactService.updateContact(ID, contact.getPersonID(),contact.getRelationship(),contact.getTitle(),
                contact.getIsReference(), contact.getIsEmergency(), contact.getIsLandlord());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }


    @GetMapping("/onboard-contact/list")
    public List<OnBoardApp_Contact> getAllContacts(){
        return this.onBoardApp_contactService.getAllContacts();
    }

    @GetMapping("/onboard-contact/{id}")
    @ResponseBody
    public OnBoardApp_Contact getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_contactService.getContactByID(ID);
    }
}
