package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.OnBoardApp_EmployeeDAO;
import com.namho.book_projc.domain.OnBoardApp_Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class OnBoardApp_EmployeeImpl implements OnBoardApp_EmployeeDAO {
    @Override
    public void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate, String visaEndDate, String driverLisence, String driver_exp) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            OnBoardApp_Employee person = new OnBoardApp_Employee(ID,personID, visaID, visaStartDate,
                    visaEndDate, driverLisence,driver_exp );
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
