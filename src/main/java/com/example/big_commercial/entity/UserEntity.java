package com.example.big_commercial.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String imagUrl;
    private String phone;
    private Double storeCredit;
    private String role;
    private Date joinDate;
    private Date lastLogin;
    private Date lastLoginDisplay;
    private Boolean isActive;
    private Boolean isNotLocked;

}
