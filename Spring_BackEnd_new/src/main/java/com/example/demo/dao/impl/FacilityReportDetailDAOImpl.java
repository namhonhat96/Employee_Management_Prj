package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.FacilityReportDAO;
import com.example.demo.dao.FacilityReportDetailDAO;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.FacilityReportDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FacilityReportDetailDAOImpl")
public class FacilityReportDetailDAOImpl extends AbstractHibernateDAO<FacilityReportDetail> implements FacilityReportDetailDAO {

    public FacilityReportDetailDAOImpl()
    {
        setClazz(FacilityReportDetail.class);
    }

    @Override
    public void addFacilityReportDetail(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate) {
        FacilityReportDetail facilityReportDetail = new FacilityReportDetail(ID,reportID, employeeID,comment,createDate,lastModificationDate);
        getCurrentSession().save(facilityReportDetail);
    }

    @Override
    public void updateFacilityReportDetail(int ID, int reportID, int employeeID, String comment, String createDate, String lastModificationDate) {
        FacilityReportDetail facilityReportDetail = getFacilityReportDetailByID(ID);
        facilityReportDetail.setReportID(reportID);
        facilityReportDetail.setEmployeeID(employeeID);
        facilityReportDetail.setComment(comment);
        facilityReportDetail.setCreateDate(createDate);
        facilityReportDetail.setLastModificationDate(lastModificationDate);
    }

    @Override
    public FacilityReportDetail getFacilityReportDetailByID(Integer id) {
        return getCurrentSession().get(FacilityReportDetail.class, id);
    }

    @Override
    public List<FacilityReportDetail> getAllFacilityReportDetails() {
        String sql = "from FacilityReportDetail";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
    
    public List<FacilityReportDetail> getFacilityReportDetailByReportID(Integer id)
    {
        String sql = "from FacilityReportDetail where reportID = :id";
        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("id", id);
        return query.list();
    }
}
