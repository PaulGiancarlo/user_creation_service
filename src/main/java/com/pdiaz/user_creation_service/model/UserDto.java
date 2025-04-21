package com.pdiaz.user_creation_service.model;

import com.pdiaz.user_creation_service.custom.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


import java.util.List;



public class UserDto {
    @NotBlank(message= "Please provide a name")
    private String name;

    @Email(message = "The email is not valid")
    @NotBlank(message = "Please provide a email")
    private String email;

    @ValidPassword()
    @NotBlank(message = "Please provide a password")
    private String password;

    @NotEmpty(message = "Please provide at least one telephone number")
    private List<PhonesDto> phones;

    public UserDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhonesDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhonesDto> phones) {
        this.phones = phones;
    }
}
