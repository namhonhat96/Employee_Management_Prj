package com.beaconfire.work_mgt_project.dao.impl;

import com.beaconfire.work_mgt_project.config.HibernateConfigUtil;
import com.beaconfire.work_mgt_project.dao.TestDAO;
import com.beaconfire.work_mgt_project.domain.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Repository
public class TestDAOImpl implements TestDAO {
    @Override
    public void addTest(int ID, String name) {
        Session session = HibernateConfigUtil.openSession();
        Transaction tx = null;
        try {
            Random rand = new Random();
            tx = session.beginTransaction();
            Test test = new Test(ID,name);
            session.save(test);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Test> getListInfo() {
        Session session = HibernateConfigUtil.openSession();
        List<Test> results = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            results = session.createQuery("from Test").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
