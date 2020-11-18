package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.OnBoardApp_PersonDAO;
import com.namho.book_projc.domain.OnBoardApp_Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class OnBoardApp_PersonDAOImpl implements OnBoardApp_PersonDAO {
    @Override
    public void addPerson(int ID, String firstname, String lastname, String middlename, String email, String cellphone, String alternatephone, String gender, int SSN, String DOB) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            OnBoardApp_Person person = new OnBoardApp_Person(ID,firstname, lastname, middlename,
                    email, cellphone,alternatephone,gender,SSN,DOB );
            session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
