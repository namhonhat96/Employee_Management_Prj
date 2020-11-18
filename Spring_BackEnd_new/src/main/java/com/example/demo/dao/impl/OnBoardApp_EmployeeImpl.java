package com.example.demo.dao.impl;

import com.example.demo.dao.AbstractHibernateDAO;
import com.example.demo.dao.OnBoardApp_EmployeeDAO;
import com.example.demo.pojo.OnBoardApp_Employee;
import org.springframework.stereotype.Repository;


@Repository
public class OnBoardApp_EmployeeImpl extends AbstractHibernateDAO<OnBoardApp_Employee> implements OnBoardApp_EmployeeDAO {
    public OnBoardApp_EmployeeImpl()
    {
        setClazz(OnBoardApp_Employee.class);
    }

    @Override
    public void addEmployee(int ID, int personID, String car, int visaID, String visaStartDate, String visaEndDate, String driverLisence, String driver_exp) {
            OnBoardApp_Employee person = new OnBoardApp_Employee(ID,personID, visaID, visaStartDate,
                    visaEndDate, driverLisence,driver_exp );
            getCurrentSession().save(person);
    }
}
