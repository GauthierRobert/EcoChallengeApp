package com.eco.userservice.service;

import com.eco.userservice.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Override
    public void doSomething(UserDto user) {
        System.out.println(user.getUsername());
    }
}