package com.beaconfire.work_mgt_project.domain;

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
@Table(name ="TestingTable", schema = "project2")
public class Test implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTestingTable")
    private int id;

    @Column(name = "nameTable")
    private String name;

}
