package com.example.demo.service;

import com.example.demo.dao.FacilityDAO;
import com.example.demo.dao.FacilityReportDAO;
import com.example.demo.pojo.Facility;
import com.example.demo.pojo.FacilityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityReportService {

    private FacilityReportDAO facilityReportDAO;


    @Autowired
    public void setFacilityReportDAO(FacilityReportDAO facilityReportDAO){
        this.facilityReportDAO = facilityReportDAO;
    }

    @Transactional
    public void addFacilityReport(int ID, String title, int employeeID, String reportDate, String description,String status){
        this.facilityReportDAO.addFacilityReport(ID, title, employeeID, reportDate, description, status);
    }

    @Transactional
    public void updateFacilityReport(int ID, String title, int employeeID, String reportDate, String description,String status){
        this.facilityReportDAO.updateFacilityReport(ID, title, employeeID,reportDate, description,status);
    }

    @Transactional
    public FacilityReport getFacilityReportByID(Integer id){
        return this.facilityReportDAO.getFacilityReportByID(id);
    }

    @Transactional
    public List<FacilityReport> getAllFacilityReports(){
        return this.facilityReportDAO.getAllFacilityReports();
    }
}
