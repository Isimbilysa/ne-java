package com.example.demo.dto;
import com.example.demo.Classes.Enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginModel {
    @NotNull
    private String firstname;

    @NotNull
    @Email
    private String email;
    @NotNull
    private String phone;

    @NotNull
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
//    @Size(min=8,max=32)
    private String password;
    @NotNull
    private ERole role;
}
