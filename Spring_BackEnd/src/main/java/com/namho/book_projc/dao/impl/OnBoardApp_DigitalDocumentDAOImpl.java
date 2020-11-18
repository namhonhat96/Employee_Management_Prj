package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.OnBoardApp_DigitialDocumentDAO;
import com.namho.book_projc.domain.OnBoardApp_DigitalDocument;
import com.namho.book_projc.domain.OnBoardApp_Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("OnBoardApp_DigitalDocumentDAOImpl")
public class OnBoardApp_DigitalDocumentDAOImpl implements OnBoardApp_DigitialDocumentDAO {
    @Override
    public void addDigitalDocument(int ID, String type, String required, String templateLocation, String description) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            OnBoardApp_DigitalDocument document = new OnBoardApp_DigitalDocument(ID,type, required, templateLocation,
                    description );
            session.save(document);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
