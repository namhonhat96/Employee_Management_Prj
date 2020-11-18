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
@Table(name = "VisaStatus_Table", schema = "project2")
public class OnBoardApp_VisaStatus implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="VisaType")
    private String visaType;

    @Column(name="Active")
    private String active;

    @Column(name="ModificationDate")
    private String modificationDate;

    @Column(name="CreateUser")
    private String createUser;
}
