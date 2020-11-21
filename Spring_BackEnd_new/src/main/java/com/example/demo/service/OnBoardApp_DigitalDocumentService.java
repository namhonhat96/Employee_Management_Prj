package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.dao.OnBoardApp_DigitialDocumentDAO;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OnBoardApp_DigitalDocumentService {
    private OnBoardApp_DigitialDocumentDAO onBoardApp_digitialDocumentDAO;

    @Autowired
    public void setOnBoardApp_digitialDocumentDAO(OnBoardApp_DigitialDocumentDAO onBoardApp_digitialDocumentDAO){
        this.onBoardApp_digitialDocumentDAO = onBoardApp_digitialDocumentDAO;
    }

    @Transactional
    public void addDigitalDocument(int ID, String type, String required, String templateLocation, String description){
        this.onBoardApp_digitialDocumentDAO.addDigitalDocument(ID,type,required,templateLocation,description);
    }

    @Transactional
    public OnBoardApp_DigitalDocument getDigitalDocumentByID(Integer id)
    {
        return this.onBoardApp_digitialDocumentDAO.getDigitalDocumentByID(id);
    }

    @Transactional
    public void updateDigitalDocument(int ID, String type, String required, String templateLocation, String description) {
        this.onBoardApp_digitialDocumentDAO.updateDigitalDocument(ID, type, required, templateLocation, description);
    }

    @Transactional
    public List<OnBoardApp_DigitalDocument> getAllDigitalDocuments(){
        return this.onBoardApp_digitialDocumentDAO.getAllDigitalDocuments();
    }
}
