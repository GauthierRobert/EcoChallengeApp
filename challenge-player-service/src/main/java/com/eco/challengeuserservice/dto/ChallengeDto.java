package com.eco.challengeuserservice.dto;

import java.io.Serializable;


public class ChallengeDto implements Serializable {

    private String id;
    private int point;
    private int level;

    public ChallengeDto() {
    }

    public ChallengeDto(String id, int point, int level, String category) {
        this.id = id;
        this.point = point;
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public int getLevel() {
        return level;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }
}
