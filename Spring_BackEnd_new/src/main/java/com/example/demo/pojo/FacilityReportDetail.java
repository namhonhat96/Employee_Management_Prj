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
@Table(name = "FacilityReportDetail_Table", schema = "project2")
public class FacilityReportDetail implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="ReportID")
    private int reportID;

    @Column(name="EmployeeID")
    private int employeeID;

    @Column(name="Comments")
    private String comment;

    @Column(name="CreateDate")
    private String createDate;

    @Column(name="LastModicationDate")
    private String lastModificationDate;
}
