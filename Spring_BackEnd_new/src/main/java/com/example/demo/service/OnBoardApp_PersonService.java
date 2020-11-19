package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_PersonDAO;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OnBoardApp_PersonService {
    private OnBoardApp_PersonDAO onBoardApp_personDAO;

    @Autowired
    public void setPersonDAO(OnBoardApp_PersonDAO onBoardApp_personDAO){
        this.onBoardApp_personDAO = onBoardApp_personDAO;
    }

    @Transactional
    public void addPerson(int ID, String firstname, String lastname, String middlename, String email, String cellphone, String alternatephone, String gender, int SSN, String DOB) {
        this.onBoardApp_personDAO.addPerson(ID,firstname,lastname,middlename,email,cellphone,alternatephone,gender,SSN,DOB);
    }

    @Transactional
    public OnBoardApp_Person getPersonByID(Integer id)
    {
        return this.onBoardApp_personDAO.getPersonByID(id);
    }
}
