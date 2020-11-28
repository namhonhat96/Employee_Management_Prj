package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.RegistrationTokenDAO;
import com.example.demo.pojo.RegistrationToken;
import com.example.demo.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RegistrationTokenDAOImpl")
public class RegistrationTokenDAOImpl  extends AbstractHibernateDAO<RegistrationToken> implements RegistrationTokenDAO {

    public RegistrationTokenDAOImpl()
    {
        setClazz(RegistrationToken.class);
    }

    @Override
    public void addRegistrationToken(int ID, String token, int validDuration, String email, String createdBy) {
        RegistrationToken registrationToken = new RegistrationToken(ID, token, validDuration, email, createdBy);
        getCurrentSession().save(registrationToken);
    }

    @Override
    public void updateRegistrationToken(int ID, String token, int validDuration, String email, String createdBy) {
        RegistrationToken registrationToken = getRegistrationTokenByID(ID);
        registrationToken.setToken(token);
        registrationToken.setValidDuration(validDuration);
        registrationToken.setEmail(email);
        registrationToken.setCreatedBy(createdBy);
        getCurrentSession().update(registrationToken);
    }

    @Override
    public RegistrationToken getRegistrationTokenByID(Integer id) {
        return getCurrentSession().get(RegistrationToken.class, id);
    }

    @Override
    public List<RegistrationToken> getRegistrationTokens() {
        String sql = "from RegistrationToken";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
