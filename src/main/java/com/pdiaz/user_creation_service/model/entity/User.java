package com.pdiaz.user_creation_service.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    String name;
    @Id
    String email;
    String password;
    String phones;
    
}
