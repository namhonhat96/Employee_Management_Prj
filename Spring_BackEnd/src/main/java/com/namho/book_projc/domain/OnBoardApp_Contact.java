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
@Table(name = "Contact_Table", schema = "project2")
public class OnBoardApp_Contact {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="PersonID")
    private int personID;

    @Column(name="Relationship")
    private String relationship;

    @Column(name="Title")
    private String title;

    @Column(name="isRewference")
    private String isReference;

    @Column(name="isEmergency")
    private String isEmergency;

    @Column(name="isLandlord")
    private String isLandlord;
}
