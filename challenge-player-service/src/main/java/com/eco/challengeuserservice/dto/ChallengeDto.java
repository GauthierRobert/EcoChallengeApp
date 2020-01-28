package com.eco.challengeuserservice.dto;

import java.io.Serializable;


public class ChallengeDto implements Serializable {

    private int point;
    private int level;
    private String category;

    public ChallengeDto() {
    }

    public ChallengeDto(int point, int level, String category) {
        this.point = point;
        this.level = level;
        this.category = category;
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
}
