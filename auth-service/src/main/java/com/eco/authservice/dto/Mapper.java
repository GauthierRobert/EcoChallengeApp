package com.eco.authservice.dto;

import com.eco.authservice.domain.User;

import static com.eco.authservice.domain.User.tempUser;

public class Mapper {

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }

    public static User toUser(UserRegistrationDto userRegistration) {
        return tempUser(userRegistration.getUsername(),userRegistration.getPassword());
    }
}
