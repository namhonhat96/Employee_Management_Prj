package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_ContactDAO;
import com.example.demo.dao.OnBoardApp_DigitialDocumentDAO;
import com.example.demo.pojo.OnBoardApp_Contact;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OnBoardApp_ContactDAOImpl")
public class OnBoardApp_ContactDAOImpl extends AbstractHibernateDAO<OnBoardApp_Contact> implements OnBoardApp_ContactDAO {
    public OnBoardApp_ContactDAOImpl()
    {
        setClazz(OnBoardApp_Contact.class);
    }

    @Override
    public void addContact(int ID, int personID, String relationship, String isReference, String isEmergency) {
        OnBoardApp_Contact contact = new OnBoardApp_Contact(ID,personID, relationship, "",isReference,
                isEmergency,"" );
        getCurrentSession().save(contact);
    }

    @Override
    public OnBoardApp_Contact getContactByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_Contact.class, id);
    }

    @Override
    public List<OnBoardApp_Contact> getAllContacts() {
        String sql = "from OnBoardApp_Contact";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
