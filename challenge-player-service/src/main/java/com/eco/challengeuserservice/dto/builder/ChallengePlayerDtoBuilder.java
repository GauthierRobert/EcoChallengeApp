package com.eco.challengeuserservice.dto.builder;

import com.eco.challengeuserservice.dto.ChallengePlayerDto;

public final class ChallengePlayerDtoBuilder {
    private String id;
    private String playerId;
    private String challengeId;
    private int validation;

    private ChallengePlayerDtoBuilder() {
    }

    public static ChallengePlayerDtoBuilder aChallengePlayerDto() {
        return new ChallengePlayerDtoBuilder();
    }

    public ChallengePlayerDtoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ChallengePlayerDtoBuilder withPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public ChallengePlayerDtoBuilder withChallengeId(String challengeId) {
        this.challengeId = challengeId;
        return this;
    }

    public ChallengePlayerDtoBuilder withValidation(int validation) {
        this.validation = validation;
        return this;
    }

    public ChallengePlayerDto build() {
        return new ChallengePlayerDto(id, playerId, challengeId, validation);
    }
}
