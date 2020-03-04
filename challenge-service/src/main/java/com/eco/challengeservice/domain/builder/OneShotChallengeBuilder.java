package com.eco.challengeservice.domain.builder;

import com.eco.challengeservice.domain.sub.Category;
import com.eco.challengeservice.domain.OneShotChallenge;
import com.eco.challengeservice.domain.sub.Stage;
import java.util.List;

public class OneShotChallengeBuilder {

    private String id;
    private String title;
    private Integer point;
    private Integer level;
    private Category category;
    private String description;

    OneShotChallengeBuilder(String id, String title, Integer point, Integer level, Category category, String description, List<Stage> stage) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.level = level;
        this.category = category;
        this.description = description;
    }

    public OneShotChallenge build() {
        return new OneShotChallenge(id, title, point, level, category, description);
    }
}