package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.service.OnBoardApp_ApplicationWorkFlowService;
import com.example.demo.service.OnBoardApp_ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OnBoardApp_ApplicationWorkFlowController {

    private OnBoardApp_ApplicationWorkFlowService onBoardApp_applicationWorkFlowService;

    @Autowired
    public void setApplicationFlowtService(OnBoardApp_ApplicationWorkFlowService onBoardApp_applicationWorkFlowService) {
        this.onBoardApp_applicationWorkFlowService = onBoardApp_applicationWorkFlowService;
    }

    @GetMapping("/onboard-app/{id}")
    @ResponseBody
    //Checking the employee application status to process homepage
    public OnBoardApp_ApplicationWorkFlow getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return onBoardApp_applicationWorkFlowService.getApplicationWorkFlowByID(ID);
    }

}
