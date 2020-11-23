package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_DigitialDocumentDAO;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import com.example.demo.pojo.OnBoardApp_Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        getCurrentSession().save(document);
    }

    @Override
    public void updateDigitalDocument(int ID, String type, String required, String templateLocation, String description) {
        OnBoardApp_DigitalDocument document = getDigitalDocumentByID(ID);
        document.setType(type);
        document.setRequired(required);
        document.setTemplateLocaiton(templateLocation);
        document.setDescription(description);
        getCurrentSession().update(document);
    }

    @Override
    public OnBoardApp_DigitalDocument getDigitalDocumentByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_DigitalDocument.class, id);
    }

    @Override
    public List<OnBoardApp_DigitalDocument> getAllDigitalDocuments() {
        String sql = "from OnBoardApp_DigitalDocument";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
