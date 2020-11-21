package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.HouseDAO;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.House;
import com.example.demo.pojo.OnBoardApp_Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("HouseDAOImpl")
public class HouseDAOImpl extends AbstractHibernateDAO<House> implements HouseDAO {
    @Override
    public void addHouse(int ID, int contactID, String address, int numberOfPerson) {
        House house = new House(ID,contactID, address, numberOfPerson);
        getCurrentSession().save(house);
    }

    @Override
    public void updateHouse(int ID, int contactID, String address, int numberOfPerson) {
        House house = getHouseByID(ID);
        house.setContactID(contactID);
        house.setAddress(address);
        house.setNumberOfPerson(numberOfPerson);
        getCurrentSession().update(house);
    }

    @Override
    public House getHouseByID(Integer id) {
        return getCurrentSession().get(House.class, id);
    }

    @Override
    public List<House> getAllHouses() {
        String sql = "from House";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
