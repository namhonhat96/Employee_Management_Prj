package com.example.demo.controller;

import com.example.demo.pojo.RegistrationToken;
import com.example.demo.service.RegistrationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class RegistrationTokenController {
    private RegistrationTokenService registrationTokenService;

    @Autowired
    public void setRegistrationTokenService(RegistrationTokenService registrationTokenService)
    {
        this.registrationTokenService = registrationTokenService;
    }

    @RequestMapping(value = "/reg_token", method = RequestMethod.POST)
    ResponseEntity<?> addRegistrationToken(@RequestBody RegistrationToken registrationToken) {
        Random random = new Random();
        int ID = random.nextInt(1000);
        this.registrationTokenService.addRegistrationToken(ID, registrationToken.getToken(), registrationToken.getValidDuration(), registrationToken.getEmail(),
                registrationToken.getCreatedBy());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/reg_token/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateRegistrationToken(@RequestBody RegistrationToken registrationToken, @PathVariable("id") Integer ID) {
        this.registrationTokenService.updateRegistrationToken(ID, registrationToken.getToken(), registrationToken.getValidDuration(), registrationToken.getEmail(),
                registrationToken.getCreatedBy());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/reg_token/list", method = RequestMethod.GET)
    public List<RegistrationToken> getRegistrationTokens(){
        List<RegistrationToken> registrationTokenList = this.registrationTokenService.getRegistrationTokens();
        return registrationTokenList;
    }

    @RequestMapping(value = "/reg_token/{id}", method = RequestMethod.GET)
    public RegistrationToken getRegistrationTokenByID(@PathVariable("id") Integer ID) {
        return this.registrationTokenService.getRegistrationTokenByID(ID);
    }
}
