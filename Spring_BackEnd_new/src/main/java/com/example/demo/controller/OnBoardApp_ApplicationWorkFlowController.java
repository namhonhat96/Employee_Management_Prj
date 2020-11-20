package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.service.OnBoardApp_ApplicationWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_ApplicationWorkFlowController {

    private OnBoardApp_ApplicationWorkFlowService onBoardApp_applicationWorkFlowService;

    @Autowired
    public void setApplicationFlowtService(OnBoardApp_ApplicationWorkFlowService onBoardApp_applicationWorkFlowService) {
        this.onBoardApp_applicationWorkFlowService = onBoardApp_applicationWorkFlowService;
    }

    @RequestMapping(value = "/onboard-app", method = RequestMethod.POST)
    ResponseEntity<?> addContact(@RequestBody OnBoardApp_ApplicationWorkFlow app) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_applicationWorkFlowService.addApplicationWorkFlow(ID, app.getEmployeeID(), app.getType());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/onboard-app/update/{id}")
    void updateEmployee(@RequestBody OnBoardApp_ApplicationWorkFlow app, @PathVariable("id") Integer ID) {
        onBoardApp_applicationWorkFlowService.updateApplicationWorkFlow(ID, app.getEmployeeID(), app.getType());
    }

    @GetMapping("/onboard-app/{id}")
    @ResponseBody
    //Checking the employee application status to process homepage
    public OnBoardApp_ApplicationWorkFlow getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return onBoardApp_applicationWorkFlowService.getApplicationWorkFlowByID(ID);
    }

    @GetMapping("/onboard-app/list")
    public List<OnBoardApp_ApplicationWorkFlow> getOnBoardApp_ApplicationWorkFlowList(){
        List<OnBoardApp_ApplicationWorkFlow> OnBoardApp_ApplicationWorkFlowlist = this.onBoardApp_applicationWorkFlowService.getAllApplicationWorkFlows();
        return OnBoardApp_ApplicationWorkFlowlist;
    }
}
