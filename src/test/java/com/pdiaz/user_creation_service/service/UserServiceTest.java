package com.pdiaz.user_creation_service.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import com.pdiaz.user_creation_service.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pdiaz.user_creation_service.model.UserResponseDto;
import com.pdiaz.user_creation_service.model.entity.User;
import com.pdiaz.user_creation_service.repository.TokenRepository;
import com.pdiaz.user_creation_service.repository.UserRepository;

@SpringBootTest
class UserServiceTest {


    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private TokenRepository tokenRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, tokenRepository);
    }

    @Test
    void getOneUser_WithValidId_ShouldReturnUser() {
        // Given
        String id = "12345";
        User mockUser = new User();
        mockUser.setId(id);
        mockUser.setCreated(LocalDateTime.now());
        mockUser.setModified(LocalDateTime.now());
        mockUser.setActive(true);


        // When
        when(userRepository.findById(id)).thenReturn(Optional.of(mockUser));
        // Then
        UserResponseDto userResponseDto = userService.getUser(id);
        assertEquals(id, userResponseDto.getId());
        assertNotNull(userResponseDto.getCreated());
        assertNotNull(userResponseDto.getModified());
        assertEquals(true, userResponseDto.getActive());

    }

    @Test
    void getUser_WithEmptyId_ThrowsException() {
        String emptyId = "";
        assertThrows(UserNotFoundException.class, () -> userService.getUser(emptyId));
        verify(userRepository, never()).findById(anyString());
    }

    @Test
    void getUser_WithNonExistentId_ThrowsException() {
        String nonExistentId = "non-existent-id";
        when(userRepository.findById(nonExistentId)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.getUser(nonExistentId));
        verify(userRepository).findById(nonExistentId);
    }
}
