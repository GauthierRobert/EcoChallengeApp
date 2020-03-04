package com.eco.challengeservice.domain.builder;

import com.eco.challengeservice.domain.sub.Category;
import com.eco.challengeservice.domain.IllimitedShotsChallenge;
import com.eco.challengeservice.domain.sub.Stage;
import java.util.List;

public class IllimitedShotsChallengeBuilder {

    private String id;
    private String title;
    private Integer point;
    private Integer level;
    private Category category;
    private String description;

    private List<Stage> stage;

    IllimitedShotsChallengeBuilder(String id, String title, Integer point, Integer level, Category category, String description) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.level = level;
        this.category = category;
        this.description = description;
    }


    public IllimitedShotsChallengeBuilder withStage(List<Stage> stage) {
        this.stage = stage;
        return this;
    }

    public IllimitedShotsChallenge build() {
        return new IllimitedShotsChallenge(id, title, point, level, category, description, stage);
    }
}