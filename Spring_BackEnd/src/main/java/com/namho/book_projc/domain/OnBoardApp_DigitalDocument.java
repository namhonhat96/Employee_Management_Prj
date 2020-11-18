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
@Table(name = "DigitalDocument_Table", schema = "project2")
public class OnBoardApp_DigitalDocument {
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
