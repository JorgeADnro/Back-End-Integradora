package com.tutorial.crudmongoback.security.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.ArrayList;

public class CreateUserDto {
	@NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "email is mandatory")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "username is mandatory")
    private String passwd;
    List<String> roles = new ArrayList<>();

    public CreateUserDto() {
    }

    public CreateUserDto(String username, String email, String passwd, List<String> roles) {
        this.username = username;
        this.email = email;
        this.passwd = passwd;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
