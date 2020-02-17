package com.eco.challengeservice.dto;

import java.io.Serializable;


public class ChallengeDto implements Serializable {

    private String id;
    private String title;
    private int point;
    private int level;
    private String category;
    private String description;

    public ChallengeDto() {
    }

    public ChallengeDto(String id, String title, int point, int level, String category, String description) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.level = level;
        this.category = category;
        this.description = description;
    }
}
