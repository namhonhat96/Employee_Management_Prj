package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.service.OnBoardApp_PersonService;
import com.example.demo.service.OnBoardApp_VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class OnBoardApp_VisaStatusController {
    private OnBoardApp_VisaStatusService onBoardApp_visaStatusService;

    @Autowired
    public void setVisaStatusService(OnBoardApp_VisaStatusService onBoardApp_visaStatusService) {
        this.onBoardApp_visaStatusService = onBoardApp_visaStatusService;
    }

    @GetMapping("/onboard-visa-status/{id}")
    @ResponseBody
    public OnBoardApp_VisaStatus getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_visaStatusService.getVisaStatusByID(ID);
    }

    @PostMapping("/onboard-visa-status")
    void addVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus) {
        Random random = new Random();
        int ID = random.nextInt();
        this.onBoardApp_visaStatusService.addVisaStatus(ID,visaStatus.getVisaType(),visaStatus.getActive(),visaStatus.getModificationDate(), visaStatus.getCreateUser());
    }

    @PostMapping("/update-visa-status")
    void updateVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus) {
        this.onBoardApp_visaStatusService.updateVisaStatus(visaStatus.getID(),visaStatus.getVisaType(),visaStatus.getActive(),visaStatus.getModificationDate(), visaStatus.getCreateUser());
    }

}
