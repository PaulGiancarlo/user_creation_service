package com.pdiaz.user_creation_service.model;





public class UserResponseDto {
    private String id;
    private String email;
    private String token;

    public UserResponseDto(String id, String email, String token) {
        this.id=id;
        this.email=email;
        this.token=token;
    }

    public UserResponseDto(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
