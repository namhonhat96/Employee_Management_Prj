package com.example.demo.service;

import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.TestDAO;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO)
    {
        this.roleDAO = roleDAO;
    }

    @Transactional
    public List<Role> getAllRoles()
    {
        return this.roleDAO.getAllRoles();
    }

    @Transactional
    public int addRole(int ID, String roleName, String description, String createDate, String modificationDate,
                       String lastModificationUser)
    {
        return this.roleDAO.addRole(ID, roleName, description, createDate, modificationDate, lastModificationUser);
    }

    @Transactional
    public Role getRoleByID(Integer id)
    {
        return this.roleDAO.getRoleByID(id);
    }

    @Transactional
    public int updateRole(int ID, String roleName, String description, String modificationDate,
                      String lastModificationUser){
        return this.roleDAO.updateRole(ID, roleName, description, modificationDate, lastModificationUser);
    }
}

