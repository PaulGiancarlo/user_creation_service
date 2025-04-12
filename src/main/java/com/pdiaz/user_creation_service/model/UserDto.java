package com.pdiaz.user_creation_service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;


@Data
public class UserDto {
    @NotBlank(message= "Please provide a name")
    private String name;

    @Email(message = "The email is not valid")
    @NotBlank(message = "Please provide a email")
    private String email;

    @NotBlank(message = "Please provide a password")
    private String password;

    @NotEmpty(message = "Please provide at least one telephone number")
    private List<PhonesDto> phones;
}
