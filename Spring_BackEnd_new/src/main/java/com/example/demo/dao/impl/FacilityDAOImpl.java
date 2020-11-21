package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.FacilityDAO;
import com.example.demo.dao.OnBoardApp_AddressDAO;
import com.example.demo.pojo.Facility;
import com.example.demo.pojo.OnBoardApp_Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FacilityDAOImpl")
public class FacilityDAOImpl  extends AbstractHibernateDAO<Facility> implements FacilityDAO {
    public FacilityDAOImpl()
    {
        setClazz(Facility.class);
    }

    @Override
    public void addFacility(int ID, String type, String description, int quantity, int houseID) {
        Facility facility = new Facility(ID,type, description, quantity,
                houseID);
        getCurrentSession().save(facility);
    }

    @Override
    public void updateFacility(int ID, String type, String description, int quantity, int houseID) {
        Facility facility = getFacilityByID(ID);
        facility.setType(type);
        facility.setDescription(description);
        facility.setHouseID(houseID);
        getCurrentSession().update(facility);
    }

    @Override
    public Facility getFacilityByID(Integer id) {
        return getCurrentSession().get(Facility.class, id);
    }

    @Override
    public List<Facility> getAllFacilities() {
        String sql = "from Facility";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
