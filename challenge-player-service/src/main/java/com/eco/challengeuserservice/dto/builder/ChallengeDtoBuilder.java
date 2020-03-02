package com.eco.challengeuserservice.dto.builder;

import com.eco.challengeuserservice.dto.ChallengeDto;

public final class ChallengeDtoBuilder {
    private String id;
    private String title;
    private int point;
    private int level;
    private String category;
    private String description;

    private ChallengeDtoBuilder() {
    }

    public static ChallengeDtoBuilder aChallengeDto() {
        return new ChallengeDtoBuilder();
    }

    public ChallengeDtoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ChallengeDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ChallengeDtoBuilder withPoint(int point) {
        this.point = point;
        return this;
    }

    public ChallengeDtoBuilder withLevel(int level) {
        this.level = level;
        return this;
    }

    public ChallengeDtoBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public ChallengeDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ChallengeDto build() {
        return new ChallengeDto(id, title, point, level, category, description);
    }
}
