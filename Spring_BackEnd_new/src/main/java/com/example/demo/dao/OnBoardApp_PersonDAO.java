package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.pojo.OnBoardApp_VisaStatus;

import java.util.List;

public interface OnBoardApp_PersonDAO {

    void addPerson(int ID, String firstname, String lastname, String middlename,
    String email, String cellphone, String alternatephone, String gender, int SSN, String DOB );

    OnBoardApp_Person getPersonByID(Integer id);
    List<OnBoardApp_Person> getAllPersons();
}
