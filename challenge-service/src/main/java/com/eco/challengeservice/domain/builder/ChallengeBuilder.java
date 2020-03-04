package com.eco.challengeservice.domain.builder;

import com.eco.challengeservice.domain.sub.Category;

public class ChallengeBuilder {

    private String id;
    private String title;
    private Integer point;
    private Integer level;
    private Category category;
    private String description;

    private ChallengeBuilder() {
    }

    public static ChallengeBuilder anIllimitedShotChallenge() {
        return new ChallengeBuilder();
    }


    public ChallengeBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ChallengeBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ChallengeBuilder withPoint(Integer point) {
        this.point = point;
        return this;
    }

    public ChallengeBuilder withLevel(Integer level) {
        this.level = level;
        return this;
    }

    public ChallengeBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public ChallengeBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public IllimitedShotsChallengeBuilder asAnIllimitedShotsChallenge() {
        return new IllimitedShotsChallengeBuilder(id, title, point, level, category, description);
    }

    public IllimitedShotsChallengeBuilder asAOneShotChallenge() {
        return new IllimitedShotsChallengeBuilder(id, title, point, level, category, description);
    }


}
