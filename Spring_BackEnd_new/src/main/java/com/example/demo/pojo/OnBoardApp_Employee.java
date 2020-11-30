package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Employee_Table", schema = "project2")
public class OnBoardApp_Employee implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "PersonID")
    private int personID;

    @Column(name="Title")
    private String title;

    @Column(name="ManagerID")
    private int managerID;

    @Column(name="StartDate")
    private String startDate;

    @Column(name="EndDate")
    private String endDate;

    @Column(name="Avartar")
    private String avartar;

    @Column(name="Car")
    private String car;

    @Column(name="VisaStatusID")
    private int visaID;

    @Column(name="VisaStartDate")
    private String visaStartDate;

    @Column(name="VisaEndDate")
    private String visaEndDate;

    @Column(name="DriverLisence")
    private String driverLisence;

    @Column(name="DriverLisence_ExpirationDate")
    private String driver_exp;

    @Column(name="HouseID")
    private Integer houseID;

    public OnBoardApp_Employee(int id, int personID, int visaID, String visaStartDate, String visaEndDate, String driverLisence, String driver_exp) {
    }
}
