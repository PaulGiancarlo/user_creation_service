package com.pdiaz.user_creation_service.custom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordValidator  implements ConstraintValidator<ValidPassword, String> {

    @Value("${user.password.regex}")
    private String userPassFormat;

    private Pattern pattern;
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        this.pattern = Pattern.compile(userPassFormat);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if(password == null || password.isBlank()) { return false; }

        return pattern.matcher(password).matches();
    }
}
