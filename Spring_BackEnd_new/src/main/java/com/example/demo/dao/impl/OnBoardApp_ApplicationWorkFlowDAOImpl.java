package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_ApplicationWorkFlowDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository("OnBoardApp_ApplicationWorkFlowDAOImpl")
public class OnBoardApp_ApplicationWorkFlowDAOImpl extends AbstractHibernateDAO<OnBoardApp_ApplicationWorkFlow> implements OnBoardApp_ApplicationWorkFlowDAO {
    public OnBoardApp_ApplicationWorkFlowDAOImpl()
    {
        setClazz(OnBoardApp_ApplicationWorkFlow.class);
    }

    @Override
    public void addApplicationWorkFlow(int ID, int employeeID, String status) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String createDate = dateFormat.format(date);
        String modificationDate = dateFormat.format(date);
        OnBoardApp_ApplicationWorkFlow application = new OnBoardApp_ApplicationWorkFlow(ID,employeeID,createDate,modificationDate,status,"","Application" );
        getCurrentSession().save(application);
    }

    @Override
    public void updateApplicationWorkFlow(int ID, String status, String comments) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String modificationDate = dateFormat.format(date);
        OnBoardApp_ApplicationWorkFlow application = getApplicationWorkFlowByID(ID);
        application.setStatus(status);
        application.setModificationDate(modificationDate);
        application.setComments(comments);
    }

    @Override
    public OnBoardApp_ApplicationWorkFlow getApplicationWorkFlowByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_ApplicationWorkFlow.class, id);
    }

    @Override
    public List<OnBoardApp_ApplicationWorkFlow> getAllApplicationWorkFlows() {
        String sql = "from OnBoardApp_ApplicationWorkFlow";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
