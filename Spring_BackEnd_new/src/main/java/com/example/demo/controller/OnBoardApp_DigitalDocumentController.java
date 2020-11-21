package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import com.example.demo.service.OnBoardApp_DigitalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/onboard-digital-doc")
    void addContact(@RequestBody OnBoardApp_DigitalDocument digitalDocument) {
        Random random = new Random();
        int ID = random.nextInt();
        onBoardApp_digitalDocumentService.addDigitalDocument(ID, digitalDocument.getType(), digitalDocument.getRequired(),
                digitalDocument.getTemplateLocaiton(), digitalDocument.getDescription());
    }

    @PostMapping("/onboard-digital-doc/update/{id}")
    void updateEmployee(@RequestBody OnBoardApp_DigitalDocument digitalDocument, @PathVariable("id") Integer ID) {
        onBoardApp_digitalDocumentService.updateDigitalDocument(ID, digitalDocument.getType(), digitalDocument.getRequired(),
                digitalDocument.getTemplateLocaiton(), digitalDocument.getDescription());
    }


    @GetMapping("/onboard-digital-doc/list")
    public List<OnBoardApp_DigitalDocument> getOnBoardApp_DigitalDocumentList(){
        List<OnBoardApp_DigitalDocument> OnBoardApp_DigitalDocumentlist = this.onBoardApp_digitalDocumentService.getAllDigitalDocuments();
        return OnBoardApp_DigitalDocumentlist;
    }

    @GetMapping("/onboard-digital-doc/{id}")
    @ResponseBody
    public OnBoardApp_DigitalDocument getDigitalDocumentByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_digitalDocumentService.getDigitalDocumentByID(ID);
    }
}
