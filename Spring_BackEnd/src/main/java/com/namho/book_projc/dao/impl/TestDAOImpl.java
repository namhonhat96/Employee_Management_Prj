package com.namho.book_projc.dao.impl;

import com.namho.book_projc.config.HibernateConfigUtil;
import com.namho.book_projc.dao.TestDAO;
import com.namho.book_projc.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Repository
public class TestDAOImpl implements TestDAO {
    @Override
    public List<Test> getTestInfo() {
        Session session = HibernateConfigUtil.openSession();
        List<Test> results = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            results = session.createQuery("FROM Test").list();
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
