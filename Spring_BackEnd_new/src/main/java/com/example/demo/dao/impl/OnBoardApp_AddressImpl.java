package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_AddressDAO;
import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.pojo.OnBoardApp_DigitalDocument;
import org.springframework.stereotype.Repository;

import java.util.Random;

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

    }
}
