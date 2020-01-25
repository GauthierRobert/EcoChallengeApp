package com.eco.authservice.web;

import com.eco.authservice.dto.UserDto;
import com.eco.authservice.dto.UserRegistrationDto;
import com.eco.authservice.domain.User;
import com.eco.authservice.service.UserService;
import java.security.Principal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eco.authservice.dto.Mapper.toDto;
import static com.eco.authservice.dto.Mapper.toUser;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private final UserService userService;

    @Autowired
    private ProducerUserCreated producer;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PostMapping
    @PreAuthorize("#oauth2.hasScope('server')")
    public UserDto createUser(@Valid @RequestBody UserRegistrationDto userRegistration) {
        User savedUser = userService.create(toUser(userRegistration));
        UserDto userDto = toDto(savedUser);
        producer.sendMessage(userDto);
        return userDto;
    }

}