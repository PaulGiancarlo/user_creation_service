package com.pdiaz.user_creation_service.controller;

import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.model.UserResponseDto;
import com.pdiaz.user_creation_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create a User
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserDto userDto) {

        UserResponseDto userResponseDto = userService.createUser(userDto);
        return ResponseEntity.ok(userResponseDto);

    }

    //Get a User
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String id) {
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.ok(userResponseDto);

    }

}
