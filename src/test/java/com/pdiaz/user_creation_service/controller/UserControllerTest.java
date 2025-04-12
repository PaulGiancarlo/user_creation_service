package com.pdiaz.user_creation_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdiaz.user_creation_service.model.PhonesDto;
import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.repository.UserRepository;
import com.pdiaz.user_creation_service.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private JwtUtil jwtUtil;


    @BeforeEach
    void setUp(){
        userRepository.deleteAll();
    }

    @Test
    void shouldCreateAUser_AndResponseOk() throws Exception{
        UserDto userDto = new UserDto();
        userDto.setName("Juan Perez");
        userDto.setEmail("juan2@gmail.com");
        userDto.setPassword("password");
        userDto.setPhones(List.of(new PhonesDto("123123123","1","56")));


        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("juan2@gmail.com"));

        assertTrue(userRepository.existsByEmail("juan2@gmail.com"));

    }

}