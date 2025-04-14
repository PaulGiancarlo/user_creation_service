package com.pdiaz.user_creation_service.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Token {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean revoked;
    private boolean expired;

    private LocalDateTime createdToken;
    private LocalDateTime expiresToken;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getCreatedToken() {
        return createdToken.toString();
    }

    public void setCreatedToken(LocalDateTime createdToken) {
        this.createdToken = createdToken;
    }

    public String getExpiresToken() {
        return expiresToken.toString();
    }

    public void setExpiresToken(LocalDateTime expiresToken) {
        this.expiresToken = expiresToken;
    }
}
