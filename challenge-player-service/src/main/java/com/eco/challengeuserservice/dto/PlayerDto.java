package com.eco.challengeuserservice.dto;

import java.io.Serializable;

public class PlayerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    
    public PlayerDto(String id) {
        this.id = id;

    }

    public String getId() {
        return id;
    }
}
