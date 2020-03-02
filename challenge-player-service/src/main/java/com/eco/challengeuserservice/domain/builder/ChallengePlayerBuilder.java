package com.eco.challengeuserservice.domain.builder;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import java.util.Date;
import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static java.util.Calendar.getInstance;
import static java.util.Collections.emptyList;

public class ChallengePlayerBuilder {

    private String id = null;
    private String playerId = null;
    private String challengeId = null;
    private boolean completed = false;
    private Date completionDate = null;
    private List<String> playerValidationIds = emptyList();

    private ChallengePlayerBuilder() {
    }


    public static ChallengePlayerBuilder aChallengePlayer() {
        return new ChallengePlayerBuilder();
    }

    public ChallengePlayerBuilder from(ChallengePlayer challengePlayer) {
        return withId(challengePlayer.getId())
                .withPlayerId(challengePlayer.getPlayerId())
                .withChallengeId(challengePlayer.getChallengeId())
                .withCompletionDate(challengePlayer.getCompletionDate())
                .isCompleted(challengePlayer.isCompleted())
                .withValidation(challengePlayer.getPlayerValidationIds());
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

    private ChallengePlayerBuilder isCompleted(boolean isCompleted) {
        this.completed = isCompleted;
        return this;
    }

    private ChallengePlayerBuilder withCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    public ChallengePlayerBuilder isCompleted() {
        return withCompletionDate(getInstance().getTime()).isCompleted(true);
    }

    public ChallengePlayerBuilder withValidation(List<String> playerValidationIds) {
        this.playerValidationIds = playerValidationIds;
        return this;
    }

    public ChallengePlayerBuilder validate(String playerId) {
        assertTrue(!playerId.equals(this.playerId));
        if (!playerValidationIds.contains(playerId)) {
            this.playerValidationIds.add(playerId);
        } else {
            throw new RuntimeException(playerId + " cannot validate twice this challenge");
        }
        return this;
    }

    public ChallengePlayer build() {
        return new ChallengePlayer(id, playerId, challengeId, completed, completionDate, playerValidationIds);
    }

}
