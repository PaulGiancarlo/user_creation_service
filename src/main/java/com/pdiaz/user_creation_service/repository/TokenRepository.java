package com.pdiaz.user_creation_service.repository;

import com.pdiaz.user_creation_service.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,String> {

}
