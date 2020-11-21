package com.example.demo.controller;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService)
    {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/onboard-role", method = RequestMethod.POST)
    ResponseEntity<?> addRole(@RequestBody User user) {
        Random random = new Random();
        int ID = random.nextInt(1000);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String createDate = dateFormat.format(date);
        roleService.addRole(ID, "Employee", "", createDate,createDate,user.getUsername());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/onboard-role/update/{id}")
    void updateRole(@RequestBody Role role, @PathVariable("id") Integer ID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = dateFormat.format(date);
        this.roleService.updateRole(ID,role.getRoleName(), role.getDescription(),
                dateString, role.getLastModificationUser());
    }

    @GetMapping("/onboard-role/list")
    public List<Role> getAllRoles(){
        List<Role> roleList = this.roleService.getAllRoles();
        return roleList;
    }

    @GetMapping("/onboard-role/{id}")
    @ResponseBody
    public Role getPersonByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.roleService.getRoleByID(ID);
    }
}
