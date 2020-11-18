package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_PersonDAO;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import org.springframework.stereotype.Repository;


@Repository
public class OnBoardApp_PersonDAOImpl extends AbstractHibernateDAO<OnBoardApp_Person> implements OnBoardApp_PersonDAO {
    public OnBoardApp_PersonDAOImpl()
    {
        setClazz(OnBoardApp_Person.class);
    }

    @Override
    public void addPerson(int ID, String firstname, String lastname, String middlename, String email, String cellphone, String alternatephone, String gender, int SSN, String DOB) {
        OnBoardApp_Person person = new OnBoardApp_Person(ID,firstname, lastname, middlename,
                email, cellphone,alternatephone,gender,SSN,DOB );
        getCurrentSession().save(person);
    }
}
