package com.example.demo.service;

import com.example.demo.dao.FacilityDAO;
import com.example.demo.dao.OnBoardApp_AddressDAO;
import com.example.demo.pojo.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityService {
    private FacilityDAO facilityDAO;

    @Autowired
    public void setFacilityDAO(FacilityDAO facilityDAO){
        this.facilityDAO = facilityDAO;
    }

    @Transactional
    public void addFacility(int ID, String type, String description, int quantity, int houseID){
        this.facilityDAO.addFacility(ID, type, description, quantity, houseID);
    }

    @Transactional
    public void updateFacility(int ID, String type, String description, int quantity, int houseID){
        this.facilityDAO.updateFacility(ID, type, description,quantity, houseID);
    }

    @Transactional
    public Facility getFacilityByID(Integer id){
        return this.facilityDAO.getFacilityByID(id);
    }

    @Transactional
    public List<Facility> getAllFacilities(){
        return this.facilityDAO.getAllFacilities();
    }
}
