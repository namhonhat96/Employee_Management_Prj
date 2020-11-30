package com.example.demo.service;

import com.example.demo.dao.FacilityReportDAO;
import com.example.demo.dao.FacilityReportDetailDAO;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.FacilityReportDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityReportDetailService {
    private FacilityReportDetailDAO facilityReportDetailDAO;

    @Autowired
    public void setFacilityReportDetailDAO(FacilityReportDetailDAO facilityReportDetailDAO){
        this.facilityReportDetailDAO = facilityReportDetailDAO;
    }

    @Transactional
    public void addFacilityReport(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate){
        this.facilityReportDetailDAO.addFacilityReportDetail(ID, reportID, employeeID, comment, createDate, lastModificationDate);
    }

    @Transactional
    public void updateFacilityReport(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate){
        this.facilityReportDetailDAO.updateFacilityReportDetail(ID, reportID, employeeID, comment, createDate, lastModificationDate);
    }

    @Transactional
    public FacilityReportDetail getFacilityReportByID(Integer id){
        return this.facilityReportDetailDAO.getFacilityReportDetailByID(id);
    }

    @Transactional
    public List<FacilityReportDetail> getAllFacilityReportDetails(){
        return this.facilityReportDetailDAO.getAllFacilityReportDetails();
    }
    
    @Transactional
    public List<FacilityReportDetail> getFacilityReportDetailsByReportID(Integer id){
        return this.facilityReportDetailDAO.getFacilityReportDetailByReportID(id);
    }
}
