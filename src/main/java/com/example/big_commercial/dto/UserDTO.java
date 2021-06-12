package com.example.big_commercial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

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
    private String joinDate;
    private String lastLogin;
    private String lastLoginDisplay;
    private Boolean isActive;
    private Boolean isNotLocked;

}
