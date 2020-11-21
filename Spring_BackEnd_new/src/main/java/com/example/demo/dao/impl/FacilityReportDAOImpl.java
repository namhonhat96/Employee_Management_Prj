package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.FacilityReportDAO;
import com.example.demo.pojo.Facility;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.OnBoardApp_Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FacilityReportDAOImpl")
public class FacilityReportDAOImpl extends AbstractHibernateDAO<FacilityReport> implements FacilityReportDAO {
    public FacilityReportDAOImpl()
    {
        setClazz(FacilityReport.class);
    }

    @Override
    public void addFacilityReport(int ID, String title, int employeeID, String reportDate, String description, String status) {
        FacilityReport facilityReport = new FacilityReport(ID,title, employeeID, reportDate,
                description, status);
        getCurrentSession().save(facilityReport);
    }

    @Override
    public void updateFacilityReport(int ID, String title, int employeeID, String reportDate, String description, String status) {
        FacilityReport facilityReport = getFacilityReportByID(ID);
        facilityReport.setTitle(title);
        facilityReport.setEmployeeID(employeeID);
        facilityReport.setReportDate(reportDate);
        facilityReport.setDescription(description);
        facilityReport.setReportDate(reportDate);
        getCurrentSession().update(facilityReport);
    }

    @Override
    public FacilityReport getFacilityReportByID(Integer id) {
        return getCurrentSession().get(FacilityReport.class, id);
    }

    @Override
    public List<FacilityReport> getAllFacilityReports() {
        String sql = "from FacilityReport";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
