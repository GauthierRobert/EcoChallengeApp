package com.eco.playerservice.domain.builder;

import com.eco.playerservice.domain.Player;

import static java.lang.Math.floorDiv;

public class PlayerBuilder {

    private String id = null;
    private String userId = null;
    private Integer point = 0;
    private Integer experience = 0;
    private Integer completedChallenge = 0;
    private Integer level = 1;

    private static final int LEVEL_UP = 10;

    private PlayerBuilder() {
    }


    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public PlayerBuilder from(Player player) {
        return withId(player.getId())
                .withUserId(player.getUserId())
                .withPoint(player.getPoint())
                .withExperience(player.getExperience())
                .withCompletedChallenge(player.getCompletedChallenge())
                .withLevel(player.getLevel());
    }

    private PlayerBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PlayerBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    private PlayerBuilder withPoint(int point) {
        this.point = point;
        return this;
    }

    public PlayerBuilder addPoint(int point) {
        this.point = this.point + point;
        withLevel(floorDiv(this.point,LEVEL_UP));
        return this;
    }


    private PlayerBuilder withExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public PlayerBuilder addExperience(int experience) {
        this.experience = this.experience + experience;
        return this;
    }


    private PlayerBuilder withCompletedChallenge(int completedChallenge) {
        this.completedChallenge = completedChallenge;
        return this;
    }

    public PlayerBuilder addCompletedChallenge() {
        this.completedChallenge++;
        return this;
    }


    private PlayerBuilder withLevel(int level) {
        this.level = level;
        return this;
    }

    public Player build() {
        return new Player(id, userId, point, experience, completedChallenge, level);
    }

}
