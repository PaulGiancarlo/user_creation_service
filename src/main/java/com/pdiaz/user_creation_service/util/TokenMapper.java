package com.pdiaz.user_creation_service.util;

import com.pdiaz.user_creation_service.model.entity.Token;
import com.pdiaz.user_creation_service.model.entity.User;

import java.time.LocalDateTime;

public class TokenMapper {

    private TokenMapper(){}

    public static Token mapToEntity(String currentToken, User user){
        Token token = new Token();
        token.setToken(currentToken);
        token.setUser(user);
        token.setCreatedToken(LocalDateTime.now());
        token.setExpiresToken(LocalDateTime.now().plusMinutes(5));
        token.setRevoked(false);
        token.setExpired(false);

        return token;
    }
}
