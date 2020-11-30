package com.example.demo.dao;

import com.example.demo.pojo.OnBoardApp_Address;
import java.util.List;

public interface OnBoardApp_AddressDAO {
    void addAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode,
                   String stateName, String stateAbbr, int personID);

    void updateAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode,
                   String stateName, String stateAbbr, int personID);

    OnBoardApp_Address getAddressByID(Integer id);
    List<OnBoardApp_Address> getAllAddresses();

    List<OnBoardApp_Address> getAddressByPersonID(Integer personID);
}
