package com.example.demo.dao.impl;


import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_ApplicationWorkFlowDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_ApplicationWorkFlow;
import com.example.demo.pojo.OnBoardApp_Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OnBoardApp_ApplicationWorkFlowDAOImpl")
public class OnBoardApp_ApplicationWorkFlowDAOImpl extends AbstractHibernateDAO<OnBoardApp_ApplicationWorkFlow> implements OnBoardApp_ApplicationWorkFlowDAO {
    public OnBoardApp_ApplicationWorkFlowDAOImpl()
    {
        setClazz(OnBoardApp_ApplicationWorkFlow.class);
    }

    @Override
    public void addApplicationWorkFlow(int ID, int employeeID, String createDate, String modificationDate, String type) {
        OnBoardApp_ApplicationWorkFlow application = new OnBoardApp_ApplicationWorkFlow(ID,employeeID,createDate,modificationDate,"","",type );
        getCurrentSession().save(application);
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
