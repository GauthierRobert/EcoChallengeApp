package com.eco.challengeuserservice.dto;

import java.io.Serializable;


public class ChallengePlayerDto implements Serializable {

    private String id;
    private int validation;
    private ChallengeDto challengeDto;


    private ChallengePlayerDto() {
    }

    public ChallengePlayerDto(String id, int validation, ChallengeDto challengeDto) {
        this.id = id;
        this.validation = validation;
        this.challengeDto = challengeDto;
    }

    public String getId() {
        return id;
    }
}
