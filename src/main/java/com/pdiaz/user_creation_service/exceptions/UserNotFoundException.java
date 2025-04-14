package com.pdiaz.user_creation_service.exceptions;

import static com.pdiaz.user_creation_service.constants.UserConstants.MESSAGE;
import static com.pdiaz.user_creation_service.constants.UserConstants.USER_NOT_FOUND;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() { super(message()); }

    private static String message() {
        return MESSAGE.concat(USER_NOT_FOUND);
    }
}
