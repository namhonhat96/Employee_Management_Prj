package com.example.demo.dao;

import com.example.demo.pojo.Facility;
import com.example.demo.pojo.OnBoardApp_Address;

import java.util.List;

public interface FacilityDAO {

    void addFacility(int ID, String type, String description, int quantity, int houseID);

    void updateFacility(int ID, String type, String description, int quantity, int houseID);

    Facility getFacilityByID(Integer id);
    List<Facility> getAllFacilities();
}
