package com.namho.book_projc.service.impl;

import com.namho.book_projc.dao.OnBoardApp_PersonDAO;
import com.namho.book_projc.service.OnBoardApp_PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnBoardApp_PersonServiceImpl implements OnBoardApp_PersonService {
    private OnBoardApp_PersonDAO onBoardApp_personDAO;

    @Autowired
    public void setTestDAO(OnBoardApp_PersonDAO onBoardApp_personDAO){
        this.onBoardApp_personDAO = onBoardApp_personDAO;
    }

    @Override
    public void addPerson(int ID, String firstname, String lastname, String middlename, String email, String cellphone, String alternatephone, String gender, int SSN, String DOB) {
        this.onBoardApp_personDAO.addPerson(ID,firstname,lastname,middlename,email,cellphone,alternatephone,gender,SSN,DOB);
    }
}
