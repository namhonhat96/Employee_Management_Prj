package com.namho.book_projc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "VisaStatus_Table", schema = "project2")
public class OnBoardApp_VisaStatus {
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
