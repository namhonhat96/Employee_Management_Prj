package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.OnBoardApp_VisaStatusDAO;
import com.namho.book_projc.domain.OnBoardApp_Person;
import com.namho.book_projc.domain.OnBoardApp_VisaStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class OnBoardApp_VisaStatusImpl implements OnBoardApp_VisaStatusDAO {
    @Override
    public void addVisaStatus(int ID, String visaType,String active, String modificationDate, String createUser) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            OnBoardApp_VisaStatus visaStatus = new OnBoardApp_VisaStatus(ID,visaType,active,modificationDate,createUser);
            session.save(visaStatus);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
