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
@Table(name = "Person_Table", schema = "project2")
public class OnBoardApp_Person implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="Firstname")
    private String firstname;

    @Column(name="Lastname")
    private String lastname;

    @Column(name="Middlename")
    private String middlename;

    @Column(name="Email")
    private String email;

    @Column(name="CellPhone")
    private String cellphone;

    @Column(name="AlternatePhone")
    private String alternatephone;

    @Column(name="Gender")
    private String gender;

    @Column(name="SSN")
    private int SSN;

    @Column(name="DOB")
    private String DOB;
}
