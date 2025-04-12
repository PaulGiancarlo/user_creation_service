package com.pdiaz.user_creation_service.service;

import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.model.UserResponseDto;
import com.pdiaz.user_creation_service.model.entity.User;
import com.pdiaz.user_creation_service.repository.UserRepository;
import com.pdiaz.user_creation_service.util.JwtUtil;
import com.pdiaz.user_creation_service.util.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Predicate;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserDto userDto){
        String email = userDto.getEmail();
        if(checkUserByEmail.test(email)){
            throw new RuntimeException("This email was previously registered");
        }
        String token = JwtUtil.generateToken(email);
        User user = UserMapper.mapToEntity(userDto, token);
        userRepository.save(user);

        return  new UserResponseDto(user.getId(), email, token);
    }

    Predicate<String> checkUserByEmail = emailCheck -> userRepository.findByEmail(emailCheck);


}
