package com.eco.challengeservice.dto;

import java.io.Serializable;


public class ChallengeDto implements Serializable {
    private String id;
    private int point;
    private int level;
    private String category;

    public ChallengeDto() {
    }

    public ChallengeDto(String id, int point, int level, String category) {
        this.id = id;
        this.point = point;
        this.level = level;
        this.category = category;
    }
}
