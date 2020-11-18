package com.namho.book_projc.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "User_Table", schema = "project2")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String userName;
    private String email;
    private String password;
    private Integer personID;
    private String createDate;
    private String modificationDate;
}
