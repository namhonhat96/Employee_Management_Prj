package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import com.example.demo.service.OnBoardApp_DigitalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class OnBoardApp_DigitalDocumentController {
    private OnBoardApp_DigitalDocumentService onBoardApp_digitalDocumentService;

    @Autowired
    public void setOnBoardApp_digitalDocumentService(OnBoardApp_DigitalDocumentService onBoardApp_digitalDocumentService) {
        this.onBoardApp_digitalDocumentService = onBoardApp_digitalDocumentService;
    }

    @RequestMapping(value = "/onboard-digital-doc", method = RequestMethod.POST)
    ResponseEntity<?> addDigitalDoc(@RequestBody OnBoardApp_DigitalDocument digitalDocument) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_digitalDocumentService.addDigitalDocument(ID, digitalDocument.getType(), digitalDocument.getRequired(),
                digitalDocument.getTemplateLocaiton(), digitalDocument.getDescription());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-digital-doc/update/{id}", method = RequestMethod.GET)
    ResponseEntity<?>  updateDigitalDoc(@RequestBody OnBoardApp_DigitalDocument digitalDocument, @PathVariable("id") Integer ID) {
        onBoardApp_digitalDocumentService.updateDigitalDocument(ID, digitalDocument.getType(), digitalDocument.getRequired(),
                digitalDocument.getTemplateLocaiton(), digitalDocument.getDescription());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-digital-doc/lists", method = RequestMethod.GET)
    public List<OnBoardApp_DigitalDocument> getAllDigitalDocuments(){
        return this.onBoardApp_digitalDocumentService.getAllDigitalDocuments();
    }

    @RequestMapping(value = "/onboard-digital-doc/{id}", method = RequestMethod.GET)
    public OnBoardApp_DigitalDocument getDigitalDocumentByID(@PathVariable("id") Integer ID) {
        return this.onBoardApp_digitalDocumentService.getDigitalDocumentByID(ID);
    }
}
