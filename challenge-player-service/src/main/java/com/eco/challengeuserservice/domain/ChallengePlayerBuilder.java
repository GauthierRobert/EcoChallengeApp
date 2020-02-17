package com.eco.challengeuserservice.domain;

import java.util.Date;

import static java.util.Calendar.getInstance;

public class ChallengePlayerBuilder {

    private String id = null;
    private String playerId = null;
    private String challengeId = null;
    private int level = 0;
    private int point = 0;
    private String category = null;
    private boolean completed = false;
    private Date completionDate = null;
    private int validation = 0;

    private ChallengePlayerBuilder() {
    }


    public static ChallengePlayerBuilder aChallengePlayer() {
        return new ChallengePlayerBuilder();
    }

    public ChallengePlayerBuilder from(ChallengePlayer challengePlayer) {
        return withId(challengePlayer.getId())
                .withPlayerId(challengePlayer.getPlayerId())
                .withChallengeId(challengePlayer.getChallengeId())
                .withLevel(challengePlayer.getLevel())
                .withPoint(challengePlayer.getPoint())
                .withCategory(challengePlayer.getCategory())
                .withCompletionDate(challengePlayer.getCompletionDate())
                .isCompleted(challengePlayer.isCompleted())
                .withValidation(challengePlayer.getValidation());
    }


    public ChallengePlayerBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ChallengePlayerBuilder withPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public ChallengePlayerBuilder withChallengeId(String challengeId) {
        this.challengeId = challengeId;
        return this;
    }

    public ChallengePlayerBuilder withLevel(int level) {
        this.level = level;
        return this;
    }

    public ChallengePlayerBuilder withPoint(int point) {
        this.point = point;
        return this;
    }

    public ChallengePlayerBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public ChallengePlayerBuilder isCompleted(boolean isCompleted) {
        this.completed = isCompleted;
        return this;
    }

    public ChallengePlayerBuilder withCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    public ChallengePlayerBuilder isCompleted() {
        return withCompletionDate(getInstance().getTime()).isCompleted(true);
    }

    public ChallengePlayerBuilder withValidation(int validation) {
        this.validation = validation;
        return this;
    }

    public ChallengePlayerBuilder validate() {
        this.validation++;
        return this;
    }

    public ChallengePlayer build() {
        return new ChallengePlayer(id, playerId, challengeId, level, point, category, completed, completionDate, validation);
    }

}
