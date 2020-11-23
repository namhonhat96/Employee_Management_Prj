package com.example.demo.dao;

import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.FacilityReportDetail;

import java.util.List;

public interface FacilityReportDetailDAO {
    void addFacilityReportDetail(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate);
    void updateFacilityReportDetail(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate);
    FacilityReportDetail getFacilityReportDetailByID(Integer id);
    List<FacilityReportDetail> getAllFacilityReportDetails();
}
