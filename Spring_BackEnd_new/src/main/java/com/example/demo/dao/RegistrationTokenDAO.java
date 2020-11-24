package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.RegistrationToken;

import java.util.List;

public interface RegistrationTokenDAO {

    void addRegistrationToken(int ID, String token,String validDuration, String email,
                       String createdBy);
    void updateRegistrationToken(int ID, String token,String validDuration, String email,
                                 String createdBy);
    RegistrationToken getRegistrationTokenByID(Integer id);
    List<RegistrationToken> getRegistrationTokens();
}
