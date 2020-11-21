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
@Table(name = "RegistrationToken_Table", schema = "project2")
public class RegistrationToken implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name="Token")
    private String token;

    @Column(name="ValidDuration")
    private int validDuration;

    @Column(name="Email")
    private String email;

    @Column(name="CreatedBy")
    private String createdBy;

}
