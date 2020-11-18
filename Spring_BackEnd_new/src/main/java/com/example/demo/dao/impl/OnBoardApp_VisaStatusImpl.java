package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_VisaStatusDAO;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import org.springframework.stereotype.Repository;

@Repository("OnBoardApp_VisaStatusImpl")
public class OnBoardApp_VisaStatusImpl extends AbstractHibernateDAO<OnBoardApp_VisaStatus> implements OnBoardApp_VisaStatusDAO {
    public OnBoardApp_VisaStatusImpl()
    {
        setClazz(OnBoardApp_VisaStatus.class);
    }

    @Override
    public void addVisaStatus(int ID, String visaType,String active, String modificationDate, String createUser) {
        OnBoardApp_VisaStatus visaStatus = new OnBoardApp_VisaStatus(ID,visaType,active,modificationDate,createUser);
        getCurrentSession().save(visaStatus);
    }
}
