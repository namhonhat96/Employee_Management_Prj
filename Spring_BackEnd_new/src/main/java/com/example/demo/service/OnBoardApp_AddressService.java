package com.example.demo.service;

import com.example.demo.dao.OnBoardApp_AddressDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OnBoardApp_AddressService {
    private OnBoardApp_AddressDAO onBoardApp_addressDAO;

    @Autowired
    public void setAddressDAO(OnBoardApp_AddressDAO onBoardApp_addressDAO){
        this.onBoardApp_addressDAO = onBoardApp_addressDAO;
    }

    @Transactional
    public void addAddress(int ID, String addressLine1, String addressLine2, String city, int zipcode,
                           String stateName, String stateAbbr, int personID){
        this.onBoardApp_addressDAO.addAdress(ID,addressLine1,addressLine2,city,zipcode,stateName,stateAbbr,personID);
    }

    @Transactional
    public void updateAddress(int ID, String addressLine1, String addressLine2, String city, int zipcode,
                              String stateName, String stateAbbr, int personID){
        this.onBoardApp_addressDAO.updateAdress(ID,addressLine1,addressLine2,city,zipcode,stateName,stateAbbr,personID);
    }

    @Transactional
    public OnBoardApp_Address getAddressByID(Integer id)
    {
        return this.onBoardApp_addressDAO.getAddressByID(id);
    }

    @Transactional
    public List<OnBoardApp_Address> getAllAddresses(){
        return this.onBoardApp_addressDAO.getAllAddresses();
    }

    @Transactional
    public List<OnBoardApp_Address> getAddressByPersonID(Integer personID){
        return this.onBoardApp_addressDAO.getAddressByPersonID(personID);
    }
}
