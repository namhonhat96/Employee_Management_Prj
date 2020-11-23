package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.TestDAO;
import com.example.demo.pojo.House;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleDAOImpl")
public class RoleDAOImpl extends AbstractHibernateDAO<Role> implements RoleDAO {
    public RoleDAOImpl()
    {
        setClazz(Role.class);
    }

    @Override
    public int addRole(int ID, String roleName, String description, String createDate, String modificationDate, String lastModificationUser) {
        Role role = new Role(ID, roleName, description, createDate, modificationDate, lastModificationUser);
        getCurrentSession().save(role);
        return 0;
    }

    @Override
    public int updateRole(int ID, String roleName, String description, String modificationDate, String lastModificationUser) {
        Role role = getRoleByID(ID);
        role.setRoleName(roleName);
        role.setDescription(description);
        role.setModificationDate(modificationDate);
        role.setLastModificationUser(lastModificationUser);
        getCurrentSession().update(role);
        return 0;
    }

    @Override
    public Role getRoleByID(Integer id) {
        return getCurrentSession().get(Role.class, id);
    }

    @Override
    public List<Role> getAllRoles() {
        String sql = "from Role";
        List result = getCurrentSession().createQuery(sql).list();
        return result;
    }
}
