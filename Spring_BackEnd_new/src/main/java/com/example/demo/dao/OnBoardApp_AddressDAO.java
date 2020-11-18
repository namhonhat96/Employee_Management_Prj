package com.example.demo.dao;

public interface OnBoardApp_AddressDAO {
    void addAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode,
                   String stateName, String stateAbbr, int personID);
}
