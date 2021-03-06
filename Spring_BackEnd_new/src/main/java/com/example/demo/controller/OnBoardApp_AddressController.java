package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.service.OnBoardApp_AddressService;
import com.example.demo.service.OnBoardApp_ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_AddressController {
    private OnBoardApp_AddressService onBoardApp_addressService;

    @Autowired
    public void setAddressService(OnBoardApp_AddressService onBoardApp_addressService) {
        this.onBoardApp_addressService = onBoardApp_addressService;
    }

    @RequestMapping(value = "/onboard-address", method = RequestMethod.POST)
    ResponseEntity<?> addAddress(@RequestBody OnBoardApp_Address address) {
        Random random = new Random();
        int ID = random.nextInt();
        this.onBoardApp_addressService.addAddress(ID,address.getAddressLine1(),address.getAddressLine2(),address.getCity(),
                address.getZipcode(),address.getStateName(),address.getStateAbbr(),address.getPersonID());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-address/update/{id}", method = RequestMethod.GET)
    ResponseEntity<?> updateAddress(@RequestBody OnBoardApp_Address address, @PathVariable("id") Integer ID) {
        this.onBoardApp_addressService.updateAddress(ID, address.getAddressLine1(), address.getAddressLine2(),
                address.getCity(), address.getZipcode(), address.getStateName(),
                address.getStateAbbr(), address.getPersonID());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-address/list", method = RequestMethod.GET)
    public List<OnBoardApp_Address> getAddresses(){
        return this.onBoardApp_addressService.getAllAddresses();
    }

    @RequestMapping(value = "/onboard-address/{id}", method = RequestMethod.GET)
    public OnBoardApp_Address getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_addressService.getAddressByID(ID);
    }

    @RequestMapping(value = "/onboard-address/personID/{id}", method = RequestMethod.GET)
    public List<OnBoardApp_Address> getContactByPersonID(@PathVariable("id") Integer ID) {
        return this.onBoardApp_addressService.getAddressByPersonID(ID);
    }
}
