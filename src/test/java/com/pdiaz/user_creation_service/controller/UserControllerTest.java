package com.pdiaz.user_creation_service.controller;

import com.pdiaz.user_creation_service.model.PhonesDto;
import com.pdiaz.user_creation_service.model.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldCreateAUser_AndResponseOk() throws Exception{
        UserDto userDto = new UserDto();
        userDto.setName("Juan Perez");
        userDto.setEmail("juan@gmail.com");
        userDto.setPassword("password");
        userDto.setPhones(List.of(new PhonesDto("123123123","1","56")));
    }

    
}