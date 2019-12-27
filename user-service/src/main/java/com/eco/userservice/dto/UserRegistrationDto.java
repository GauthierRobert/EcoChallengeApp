package com.eco.userservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRegistrationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    private UserRegistrationDto() {
    }

    public UserRegistrationDto(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}