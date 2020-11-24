package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_VisaStatusDAO;
import com.example.demo.dao.RegistrationTokenDAO;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegistrationTokenService {
    private RegistrationTokenDAO registrationTokenDAO;

    @Autowired
    public void setRegistrationTokenDAO(RegistrationTokenDAO registrationTokenDAO){
        this.registrationTokenDAO = registrationTokenDAO;
    }

    @Transactional
    public void addRegistrationToken(int ID, String token,String validDuration, String email,
                              String createdBy){
        this.registrationTokenDAO.addRegistrationToken(ID,token,validDuration,email,createdBy);
    }

    @Transactional
    public RegistrationToken getRegistrationTokenByID(Integer id)
    {
        return this.registrationTokenDAO.getRegistrationTokenByID(id);
    }

    @Transactional
    public void updateRegistrationToken(int ID, String token,String validDuration, String email,
                                 String createdBy){
        this.registrationTokenDAO.updateRegistrationToken(ID,token,validDuration,email,createdBy);
    }

    @Transactional
    public List<RegistrationToken> getRegistrationTokens(){
        return this.registrationTokenDAO.getRegistrationTokens();
    }

}
