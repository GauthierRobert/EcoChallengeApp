package com.eco.challengeuserservice.dto;

import java.io.Serializable;
import java.util.List;

public class PlayerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private int point;

    private int experience;

    private int completedChallenge;

    private int level;

    private List<String> contests;

    private PlayerDto() {
    }

    public PlayerDto(String id, int point, int experience, int completedChallenge, int level, List<String> contests) {
        this.id = id;
        this.point = point;
        this.experience = experience;
        this.completedChallenge = completedChallenge;
        this.level = level;
        this.contests = contests;
    }

    public String getId() {
        return id;
    }

}
