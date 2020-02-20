package com.eco.challengeservice.dto;

import java.io.Serializable;


public class ChallengeValidatedDto implements Serializable {

    private String playerId;
    private int point;
    private int experience;

    private ChallengeValidatedDto() {
    }

    public ChallengeValidatedDto(String playerId, int point, int experience) {
        this.playerId = playerId;
        this.point = point;
        this.experience = experience;
    }
}
