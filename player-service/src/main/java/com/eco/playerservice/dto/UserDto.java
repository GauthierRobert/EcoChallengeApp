package com.eco.playerservice.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;


    public UserDto(String id, String username) {
        this.id = id;
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}