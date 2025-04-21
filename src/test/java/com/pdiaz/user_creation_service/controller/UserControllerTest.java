package com.pdiaz.user_creation_service.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        UserDto userDto = createUserDto();


        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.token").isNotEmpty())
                .andExpect(jsonPath("$.active").value(Boolean.TRUE.toString()));

        assertTrue(userRepository.existsByEmail("juan2@gmail.com"));

    }


    private UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setName("Juan Perez");
        userDto.setEmail("juan2@gmail.com");
        userDto.setPassword("passwoRd13_");
        userDto.setPhones(List.of(new PhonesDto("123123123","1","56")));
        return userDto;
    }

}