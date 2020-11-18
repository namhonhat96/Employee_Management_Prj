package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.OnBoardApp_AddressDAO;
import com.namho.book_projc.domain.OnBoardApp_Address;
import com.namho.book_projc.domain.OnBoardApp_Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("OnBoardApp_AddressImpl")
public class OnBoardApp_AddressImpl implements OnBoardApp_AddressDAO {
    @Override
    public void addAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode, String stateName, String stateAbbr, int personID) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            OnBoardApp_Address address = new OnBoardApp_Address(ID,addressLine1, addressLine2, city,
                    zipcode, stateName,stateAbbr,personID);
            session.save(address);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
