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
@Table(name = "ApplicationWorkFlow_Table", schema = "project2")
public class OnBoardApp_ApplicationWorkFlow {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="EmployeeID")
    private int employeeID;

    @Column(name="CreateDate")
    private String createDate;

    @Column(name="ModificationDate")
    private String modificationDate;

    @Column(name="Status")
    private String status;

    @Column(name="Comments")
    private String comments;

    @Column(name="Type")
    private String type;
}
