package com.example.demo.service;


import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.dao.OnBoardApp_PersonDAO;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OnBoardApp_ContactService {
    private OnBoardApp_ContactDAO onBoardApp_contactDAO;

    @Autowired
    public void setOnBoardApp_contactDAO(OnBoardApp_ContactDAO onBoardApp_contactDAO){
        this.onBoardApp_contactDAO = onBoardApp_contactDAO;
    }

    @Transactional
    public void addContact(int ID, int personID, String relationship, String isReference, String isEmergency){
        this.onBoardApp_contactDAO.addContact(ID,personID,relationship,isReference,isEmergency);
    }

    @Transactional
    public OnBoardApp_Contact getContactByID(Integer id)
    {
        return this.onBoardApp_contactDAO.getContactByID(id);
    }
}
