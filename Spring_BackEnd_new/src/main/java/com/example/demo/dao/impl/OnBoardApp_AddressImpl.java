package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_AddressDAO;
import com.example.demo.pojo.OnBoardApp_Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OnBoardApp_AddressImpl")
public class OnBoardApp_AddressImpl extends AbstractHibernateDAO<OnBoardApp_Address> implements OnBoardApp_AddressDAO {
    public OnBoardApp_AddressImpl()
    {
        setClazz(OnBoardApp_Address.class);
    }

    @Override
    public void addAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode, String stateName, String stateAbbr, int personID) {
            OnBoardApp_Address address = new OnBoardApp_Address(ID,addressLine1, addressLine2, city,
                    zipcode, stateName,stateAbbr,personID);
        getCurrentSession().save(address);
    }

    @Override
    public void updateAdress(int ID, String addressLine1, String addressLine2, String city, int zipcode, String stateName, String stateAbbr, int personID) {
        OnBoardApp_Address address = getAddressByID(ID);
        address.setAddressLine1(addressLine1);
        address.setAddressLine2(addressLine2);
        address.setCity(city);
        address.setZipcode(zipcode);
        address.setStateName(stateName);
        address.setStateAbbr(stateAbbr);
        address.setPersonID(personID);
        getCurrentSession().update(address);
    }

    @Override
    public OnBoardApp_Address getAddressByID(Integer id) {
        return getCurrentSession().get(OnBoardApp_Address.class, id);
    }

    @Override
    public List<OnBoardApp_Address> getAllAddresses() {
        return null;
    }
}
