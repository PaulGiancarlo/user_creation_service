package com.pdiaz.user_creation_service.service;

import static com.pdiaz.user_creation_service.util.TokenMapper.mapToEntity;

import com.pdiaz.user_creation_service.exceptions.UserAlreadyExistException;
import com.pdiaz.user_creation_service.exceptions.UserNotFoundException;
import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.model.UserResponseDto;
import com.pdiaz.user_creation_service.model.entity.User;
import com.pdiaz.user_creation_service.repository.TokenRepository;
import com.pdiaz.user_creation_service.repository.UserRepository;
import com.pdiaz.user_creation_service.util.JwtUtil;
import com.pdiaz.user_creation_service.util.UserMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    public UserService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public UserResponseDto createUser(UserDto userDto){
        String email = userDto.getEmail();
        boolean validation = userRepository.existsByEmail(email);
        if(validation){
            throw new UserAlreadyExistException();
        }

        User user = UserMapper.mapToEntity(userDto);

        String token = JwtUtil.generateToken(user.getId(), email);
        userRepository.save(user);

        //Save the token
        tokenRepository.save(mapToEntity(token, user));

        return  new UserResponseDto(user.getId(), user.getCreated(), user.getModified(), user.getActive());
    }

    public UserResponseDto getUser(String id) {
        if(id.isEmpty()) {
          throw new UserNotFoundException();
        }

        Optional<User> user = userRepository.findById(id);
        User currentUser = user.orElseThrow(UserNotFoundException::new);
        return new UserResponseDto(currentUser.getId(),currentUser.getCreated(),
                currentUser.getModified(), currentUser.getActive());
    }


}
