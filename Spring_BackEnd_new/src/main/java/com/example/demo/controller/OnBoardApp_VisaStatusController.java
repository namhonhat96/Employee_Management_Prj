package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Test;
import com.example.demo.service.OnBoardApp_PersonService;
import com.example.demo.service.OnBoardApp_VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    @RequestMapping(value = "/onboard-visa-status", method = RequestMethod.POST)
    ResponseEntity<?> addVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus) {
        this.onBoardApp_visaStatusService.addVisaStatus(visaStatus.getID(),visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-visa-status/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus, @PathVariable("id") Integer ID) {
        this.onBoardApp_visaStatusService.updateVisaStatus(ID,visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-visa-status/list", method = RequestMethod.GET)
    public List<OnBoardApp_VisaStatus> getOnBoardApp_VisaStatusList(){
        return this.onBoardApp_visaStatusService.getAllVisaStatus();
    }

    @RequestMapping(value = "/onboard-visa-status/{id}", method = RequestMethod.GET)
    public OnBoardApp_VisaStatus getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_visaStatusService.getVisaStatusByID(ID);
    }

    /*
    Multipart to upload and download file from Angular
     */
    List<String> files = new ArrayList<String>();
    private final Path rootLocation = Paths.get("_Path_To_Save_The_File");

    @PostMapping("/savefile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message;
        try {
            try {
                Files.copy(file.getInputStream(), this.rootLocation.resolve("Capture.jpg"));
            } catch (Exception e) {
                throw new RuntimeException("FAIL!");
            }
            files.add(file.getOriginalFilename());

            message = "Successfully uploaded!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Failed to upload!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
    /*
    =====================================================
     */

}
