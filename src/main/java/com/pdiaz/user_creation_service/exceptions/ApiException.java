package com.pdiaz.user_creation_service.exceptions;


public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }

}
