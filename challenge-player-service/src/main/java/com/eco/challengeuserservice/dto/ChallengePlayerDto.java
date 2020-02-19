package com.eco.challengeuserservice.dto;

import java.io.Serializable;


public class ChallengePlayerDto implements Serializable {

    private String id;
    private String playerId;
    private String challengeId;
    private int validation;

    private ChallengePlayerDto() {
    }

    public ChallengePlayerDto(String id, String playerId, String challengeId, int validation) {
        this.id = id;
        this.validation = validation;
        this.playerId = playerId;
        this.challengeId = challengeId;
    }


    public String getId() {
        return id;
    }
}
