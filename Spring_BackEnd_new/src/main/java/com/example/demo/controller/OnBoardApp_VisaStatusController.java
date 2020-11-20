package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Test;
import com.example.demo.service.OnBoardApp_PersonService;
import com.example.demo.service.OnBoardApp_VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_VisaStatusController {
    private OnBoardApp_VisaStatusService onBoardApp_visaStatusService;

    @Autowired
    public void setVisaStatusService(OnBoardApp_VisaStatusService onBoardApp_visaStatusService) {
        this.onBoardApp_visaStatusService = onBoardApp_visaStatusService;
    }

    @PostMapping("/onboard-visa-status")
    void addVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus) {
        Random random = new Random();
        int ID = random.nextInt();
        this.onBoardApp_visaStatusService.addVisaStatus(ID,visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
    }

    @PostMapping("/onboard-visa-status/update/{id}")
    void updateVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus, @PathVariable("id") Integer ID) {
        this.onBoardApp_visaStatusService.updateVisaStatus(ID,visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
    }

    @GetMapping("/onboard-visa-status/list")
    public List<OnBoardApp_VisaStatus> getOnBoardApp_VisaStatusList(){
        List<OnBoardApp_VisaStatus> OnBoardApp_VisaStatuslist = this.onBoardApp_visaStatusService.getAllVisaStatus();
        return OnBoardApp_VisaStatuslist;
    }

    @GetMapping("/onboard-visa-status/{id}")
    @ResponseBody
    public OnBoardApp_VisaStatus getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_visaStatusService.getVisaStatusByID(ID);
    }

}
