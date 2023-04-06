package com.tutorial.crudmongoback.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUserDto {
    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "password is mandatory")
    private String passwd;

    public LoginUserDto() {
    }

    public LoginUserDto(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String password) {
        this.passwd = password;
    }
}
