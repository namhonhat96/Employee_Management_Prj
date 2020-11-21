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
@Table(name = "FacilityReport_Table", schema = "project2")
public class FacilityReport implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="Title")
    private String title;

    @Column(name="EmployeeID")
    private int employeeID;

    @Column(name="ReportDate")
    private String reportDate;

    @Column(name="Description")
    private String description;

    @Column(name="Status")
    private String status;
}
