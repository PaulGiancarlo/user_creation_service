package com.pdiaz.user_creation_service.model;

import lombok.Data;

@Data
public class UserResponseDto {
    private String id;
    private String email;
    private String token;

    public UserResponseDto(String id, String email, String token) {
        this.id=id;
        this.email=email;
        this.token=token;
    }
}
