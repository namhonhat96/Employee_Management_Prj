package com.example.demo.service;

import com.example.demo.dao.FacilityDAO;
import com.example.demo.dao.HouseDAO;
import com.example.demo.pojo.Facility;
import com.example.demo.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseService {
private HouseDAO houseDAO;

    @Autowired
    public void setHouseDAO(HouseDAO houseDAO){
        this.houseDAO = houseDAO;
    }


    @Transactional
    public void addHouse(int ID, int contactID, String address, int numberOfPerson){
        this.houseDAO.addHouse(ID, contactID, address, numberOfPerson);
    }

    @Transactional
    public void updateHouse(int ID, int contactID, String address, int numberOfPerson){
        this.houseDAO.updateHouse(ID, contactID, address, numberOfPerson);
    }

    @Transactional
    public void deleteHouse(int ID){
        this.deleteHouse(ID);
    }

    @Transactional
    public House getHouseByID(Integer id){
        return this.houseDAO.getHouseByID(id);
    }

    @Transactional
    public List<House> getAllHouses(){
        return this.houseDAO.getAllHouses();
    }

}
