package com.eco.playerservice.dto.builder;

import com.eco.playerservice.dto.PlayerDto;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

public final class PlayerDtoBuilder {

    private String id = null;
    private Integer point = 0;
    private Integer experience = 0;
    private Integer completedChallenge = 0;
    private Integer level = 1;
    private List<String> contests = emptyList();

    private PlayerDtoBuilder() {
    }

    public static PlayerDtoBuilder aPlayerDto() {
        return new PlayerDtoBuilder();
    }

    public PlayerDtoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PlayerDtoBuilder withPoint(int point) {
        this.point = point;
        return this;
    }

    public PlayerDtoBuilder withExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public PlayerDtoBuilder withCompletedChallenge(int completedChallenge) {
        this.completedChallenge = completedChallenge;
        return this;
    }

    public PlayerDtoBuilder withLevel(int level) {
        this.level = level;
        return this;
    }

    public PlayerDtoBuilder withContests(List<String> contests) {
        this.contests = newArrayList(contests);
        return this;
    }

    public PlayerDto build() {
        return new PlayerDto(id, point, experience, completedChallenge, level, contests);
    }
}
