package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;

import java.util.List;

public interface OnBoardApp_ContactDAO {
    void addContact(int ID, int personID, String relationship, String isReference, String isEmergency);
    void updateContact(int ID, int personID, String relationship, String title, String isReference, String isEmergency, String isLandlord);
    OnBoardApp_Contact getContactByID(Integer id);
    List<OnBoardApp_Contact> getAllContacts();
}
