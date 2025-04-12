package com.pdiaz.user_creation_service.controller;

import com.pdiaz.user_creation_service.exceptions.UserAlreadyExistException;
import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.model.UserResponseDto;
import com.pdiaz.user_creation_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create a User
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDto userDto){
        try{
            UserResponseDto userResponseDto = userService.createUser(userDto);
            return ResponseEntity.ok(userResponseDto);
        }
        catch (Exception e){
            throw new UserAlreadyExistException();
        }
    }

    //Get a User
    //Patch a User
    //Put a User
    //Delete a User



}
