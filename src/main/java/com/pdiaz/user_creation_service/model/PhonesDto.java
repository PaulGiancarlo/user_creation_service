package com.pdiaz.user_creation_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PhonesDto {
    @NotBlank(message = "Please add a valid number")
    @Size(min=2, max= 9, message = "Please add a valid phone number")
    private String number;
    @NotBlank(message = "Please add a City Code")
    private String cityCode;
    @NotBlank(message = "Please add a Country Code")
    private String countryCode;

}
