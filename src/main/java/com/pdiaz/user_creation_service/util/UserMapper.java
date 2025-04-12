package com.pdiaz.user_creation_service.util;

import com.pdiaz.user_creation_service.model.UserDto;
import com.pdiaz.user_creation_service.model.entity.Phones;
import com.pdiaz.user_creation_service.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {
        public static User mapToEntity(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        if(userDto.getPhones()!=null) {
            List<Phones> phones = userDto.getPhones().stream().map(phoneDto -> {
                Phones phone = new Phones();
                phone.setNumber(phoneDto.getNumber());
                phone.setCityCode(phoneDto.getCityCode());
                phone.setCountryCode(phoneDto.getCountryCode());
                phone.setUser(user);
                return phone;
            }).collect(Collectors.toList());

            user.setPhones(phones);
        }
        return user;
    }
}
