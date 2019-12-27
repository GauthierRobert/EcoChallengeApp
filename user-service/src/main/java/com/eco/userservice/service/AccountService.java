package com.eco.userservice.service;

import com.eco.userservice.dto.UserDto;
import com.eco.userservice.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    void doSomething(UserDto user);
}