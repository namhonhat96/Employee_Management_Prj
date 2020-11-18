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
@Table(name = "DigitalDocument_Table", schema = "project2")
public class OnBoardApp_DigitalDocument implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="Type")
    private String type;

    @Column(name="Required")
    private String required;

    @Column(name="TemplateLocation")
    private String templateLocaiton;

    @Column(name="Description")
    private String description;
}
