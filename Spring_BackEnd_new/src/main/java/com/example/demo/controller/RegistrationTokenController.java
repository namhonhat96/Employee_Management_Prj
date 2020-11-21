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
    ResponseEntity<?> addRole(@RequestBody RegistrationToken registrationToken) {
        Random random = new Random();
        int ID = random.nextInt(1000);
        this.registrationTokenService.addRegistrationToken(ID, registrationToken.getToken(), registrationToken.getValidDuration(), registrationToken.getEmail(),
                registrationToken.getCreatedBy());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/reg_token/update/{id}")
    void updateRole(@RequestBody RegistrationToken registrationToken, @PathVariable("id") Integer ID) {
        this.registrationTokenService.updateRegistrationToken(ID, registrationToken.getToken(), registrationToken.getValidDuration(), registrationToken.getEmail(),
                registrationToken.getCreatedBy());
    }

    @GetMapping("/reg_token/list")
    public List<RegistrationToken> getRegistrationTokens(){
        List<RegistrationToken> registrationTokenList = this.registrationTokenService.getRegistrationTokens();
        return registrationTokenList;
    }

    @GetMapping("/reg_token/{id}")
    @ResponseBody
    public RegistrationToken getRegistrationTokenByID(@PathVariable("id") Integer ID) {
        return this.registrationTokenService.getRegistrationTokenByID(ID);
    }


}
