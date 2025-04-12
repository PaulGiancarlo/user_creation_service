package com.pdiaz.user_creation_service.exceptions;

import com.pdiaz.user_creation_service.model.entity.User;

import java.util.Map;

import static com.pdiaz.user_creation_service.constants.UserConstants.ALREADY_REGISTERED_EMAIL;
import static com.pdiaz.user_creation_service.constants.UserConstants.MESSAGE;

public class UserAlreadyExistException extends ApiException{

    public UserAlreadyExistException(){
        super(errorMessage());
    }

    private static String errorMessage(){
        return MESSAGE.concat(ALREADY_REGISTERED_EMAIL);
    }
}
