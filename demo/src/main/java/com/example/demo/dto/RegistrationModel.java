package com.example.demo.dto;
import lombok.Getter;

import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegistrationModel {

    @NotNull
    private String firstname;

    @NotNull
    @Email
    private String email;
    @NotNull
    private String telephone;

    @NotNull
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
//    @Size(min=8,max=32)
    private String password;



}