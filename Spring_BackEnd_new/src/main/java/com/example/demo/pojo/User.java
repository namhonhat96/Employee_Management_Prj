package com.example.demo.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Table", schema = "project2")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String username;
    private String email;
    private String password;
    private Integer personID;
    private String createDate;
    private String modificationDate;
}
