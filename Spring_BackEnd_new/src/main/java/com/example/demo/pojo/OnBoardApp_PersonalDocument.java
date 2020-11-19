package com.example.demo.pojo;

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
@Table(name = "PersonalDocument_Table", schema = "project2")
public class OnBoardApp_PersonalDocument {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="EmployeeID")
    private int employeeID;

    @Column(name="Path")
    private String path;

    @Column(name="Title")
    private String title;

    @Column(name="Comment")
    private String comment;

    @Column(name="CteatedDate")
    private String createDate;

    @Column(name="CreateBy")
    private String createBy;

}
