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
@Table(name = "Address_Table", schema = "project2")
public class OnBoardApp_Address implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="AddressLine1")
    private String addressLine1;

    @Column(name="AddressLine2")
    private String addressLine2;

    @Column(name="City")
    private String city;

    @Column(name="zipcode")
    private int zipcode;

    @Column(name="StateName")
    private String stateName;

    @Column(name="StateAbbr")
    private String stateAbbr;

    @Column(name="personID")
    private int personID;
}
