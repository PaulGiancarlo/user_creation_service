package com.pdiaz.user_creation_service.repository;


import com.pdiaz.user_creation_service.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean findByEmail(String email);

}
