package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_DigitialDocumentDAO;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import com.example.demo.pojo.OnBoardApp_Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("OnBoardApp_DigitalDocumentDAOImpl")
public class OnBoardApp_DigitalDocumentDAOImpl  extends AbstractHibernateDAO<OnBoardApp_DigitalDocument> implements OnBoardApp_DigitialDocumentDAO {

    public OnBoardApp_DigitalDocumentDAOImpl()
    {
        setClazz(OnBoardApp_DigitalDocument.class);
    }

    @Override
    public void addDigitalDocument(int ID, String type, String required, String templateLocation, String description) {

        OnBoardApp_DigitalDocument document = new OnBoardApp_DigitalDocument(ID,type, required, templateLocation,
                    description );

    }
}
