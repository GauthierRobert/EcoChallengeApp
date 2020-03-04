package com.eco.challengeservice.domain;

import com.eco.challengeservice.domain.sub.Category;

public class OneShotChallenge extends Challenge {


    public OneShotChallenge(String id, String title, Integer point, Integer level, Category category, String description) {
        super(id, title, point, level, category, description);
    }


}
