package com.pdiaz.user_creation_service.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    String name;
    String email;
    String password;
    String phones;
    
}
