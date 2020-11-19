package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_VisaStatusDAO;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public OnBoardApp_VisaStatus getVisaStatusByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_VisaStatus.class, id);
    }

    @Override
    public List<OnBoardApp_VisaStatus> getAllVisaStatus() {
        String sql = "from OnBoardApp_VisaStatus";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }

    @Override
    public void updateVisaStatus(int ID, String visaType, String active, String modificationDate, String createUser) {
        OnBoardApp_VisaStatus visaStatus = getVisaStatusByID(ID);
        if(visaStatus!= null){
            //Visa status exists
            visaStatus.setVisaType(visaType);
            visaStatus.setActive(active);
            visaStatus.setModificationDate(modificationDate);
            getCurrentSession().update(visaStatus);
        }
    }
}
