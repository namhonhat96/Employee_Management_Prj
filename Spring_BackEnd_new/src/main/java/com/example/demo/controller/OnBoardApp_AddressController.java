package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.service.OnBoardApp_AddressService;
import com.example.demo.service.OnBoardApp_ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class OnBoardApp_AddressController {
    private OnBoardApp_AddressService onBoardApp_addressService;

    @Autowired
    public void setAddressService(OnBoardApp_AddressService onBoardApp_addressService) {
        this.onBoardApp_addressService = onBoardApp_addressService;
    }

    @GetMapping("/onboard-address/{id}")
    @ResponseBody
    public OnBoardApp_Address getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_addressService.getAddressByID(ID);
    }

    @PostMapping("/onboard-address")
    void addContact(@RequestBody OnBoardApp_Address address) {
        Random random = new Random();
        int ID = random.nextInt();
        this.onBoardApp_addressService.addAddress(ID,address.getAddressLine1(),address.getAddressLine2(),address.getCity(),
                address.getZipcode(),address.getStateName(),address.getStateAbbr(),address.getPersonID());
    }
}
