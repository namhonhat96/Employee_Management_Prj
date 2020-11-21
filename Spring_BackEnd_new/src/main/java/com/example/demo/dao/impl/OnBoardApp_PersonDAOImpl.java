package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_PersonDAO;
import com.example.demo.pojo.OnBoardApp_Person;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("OnBoardApp_PersonDAOImpl")
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

    @Override
    public void updatePerson(int ID, String firstname, String lastname, String middlename, String email, String cellphone, String alternatephone, String gender, int SSN, String DOB) {
        OnBoardApp_Person person = getPersonByID(ID);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setMiddlename(middlename);
        person.setCellphone(alternatephone);
        person.setAlternatephone(alternatephone);
        person.setEmail(email);
        person.setGender(gender);
        person.setSSN(SSN);
        person.setDOB(DOB);
        getCurrentSession().update(person);
    }

    @Override
    public OnBoardApp_Person getPersonByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_Person.class, id);
    }

    @Override
    public List<OnBoardApp_Person> getAllPersons() {
        String sql = "from OnBoardApp_Person";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
