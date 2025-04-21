package com.pdiaz.user_creation_service.model;





public class UserResponseDto {
    private String id;
    private String token;

    private String created;

    private String modified;

    private Boolean active;

    public UserResponseDto(String id, String created, String modified, Boolean active ) {
        this.id=id;
        this.created=created;
        this.modified=modified;
        this.active=active;
    }

    public UserResponseDto(String id,String token, String created, String modified, Boolean active ) {
        this.id=id;
        this.token=token;
        this.created=created;
        this.modified=modified;
        this.active=active;
    }

    public UserResponseDto(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
