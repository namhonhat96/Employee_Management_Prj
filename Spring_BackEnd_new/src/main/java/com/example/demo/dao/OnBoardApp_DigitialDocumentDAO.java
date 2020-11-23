package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import com.example.demo.pojo.OnBoardApp_Employee;

import java.util.List;

public interface OnBoardApp_DigitialDocumentDAO {
    void addDigitalDocument(int ID, String type, String required, String templateLocation, String description);
    void updateDigitalDocument(int ID, String type, String required, String templateLocation, String description);
    OnBoardApp_DigitalDocument getDigitalDocumentByID(Integer id);
    List<OnBoardApp_DigitalDocument> getAllDigitalDocuments();
}
