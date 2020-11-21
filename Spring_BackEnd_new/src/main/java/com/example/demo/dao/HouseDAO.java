package com.example.demo.dao;

import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.House;

import java.util.List;

public interface HouseDAO {
    void addHouse(int ID, int contactID, String address, int numberOfPerson);
    void updateHouse(int ID, int contactID, String address, int numberOfPerson);
    House getHouseByID(Integer id);
    List<House> getAllHouses();
}
