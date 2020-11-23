package com.example.demo.dao;

import com.example.demo.pojo.Role;

import java.util.List;

public interface RoleDAO {

    int addRole(int ID, String roleName, String description, String createDate, String modificationDate,
                String lastModificationUser);
    int updateRole(int ID, String roleName, String description,String modificationDate,
                   String lastModificationUser);
    Role getRoleByID(Integer id);
    List<Role> getAllRoles();
}
