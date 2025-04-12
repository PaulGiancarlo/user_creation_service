package com.pdiaz.user_creation_service.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "phones")
@Getter
@Setter
public class Phones {
@Id
private String id;
private String number;
private String cityCode;
private String countryCode;
@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;

@PrePersist
public void prePersist() {
    
    this.id = UUID.randomUUID().toString();
    
}
}