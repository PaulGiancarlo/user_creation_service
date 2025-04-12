package com.pdiaz.user_creation_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class PhonesDto {
    @NotBlank(message = "Please add a valid number")
    @Size(min=2, max= 9, message = "Please add a valid phone number")
    private String number;
    @NotBlank(message = "Please add a City Code")
    private String cityCode;
    @NotBlank(message = "Please add a Country Code")
    private String countryCode;

    public PhonesDto(){}

    public PhonesDto(String number, String cityCode, String countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode= countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
