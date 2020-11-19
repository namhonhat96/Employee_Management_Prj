package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.User;

import java.util.List;

public interface OnBoardApp_VisaStatusDAO {
    void addVisaStatus(int ID, String visaType,String active,
                   String modificationDate, String createUser);
    OnBoardApp_VisaStatus getVisaStatusByID(Integer id);
    List<OnBoardApp_VisaStatus> getAllVisaStatus();

    void updateVisaStatus(int ID, String visaType, String active,
                          String modificationDate, String createUser);
}
