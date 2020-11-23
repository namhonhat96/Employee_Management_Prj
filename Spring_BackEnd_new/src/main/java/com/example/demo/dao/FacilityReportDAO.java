package com.example.demo.dao;

import com.example.demo.pojo.FacilityReport;

import java.util.List;

public interface FacilityReportDAO {
    void addFacilityReport(int ID, String title, int employeeID, String reportDate, String description,String status);

    void updateFacilityReport(int ID, String title, int employeeID, String reportDate, String description,String status );

    FacilityReport getFacilityReportByID(Integer id);
    List<FacilityReport> getAllFacilityReports();
}
