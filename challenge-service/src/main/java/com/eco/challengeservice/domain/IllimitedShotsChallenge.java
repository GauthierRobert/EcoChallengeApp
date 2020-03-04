package com.eco.challengeservice.domain;

import com.eco.challengeservice.domain.sub.Category;
import com.eco.challengeservice.domain.sub.Stage;
import java.util.List;

public class IllimitedShotsChallenge extends Challenge {

    private List<Stage> stage;

    public IllimitedShotsChallenge(String id, String title, Integer point, Integer level, Category category, String description, List<Stage> stage) {
        super(id, title, point, level, category, description);
        this.stage = stage;
    }

}
