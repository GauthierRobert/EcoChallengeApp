package com.eco.challengeuserservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.eco.challengeuserservice.domain.ChallengePlayerBuilder.aChallengePlayer;

@Document
public class ChallengePlayer implements Serializable {

    @Id
    private String id;

    private String playerId;

    private String challengeId;

    private boolean completed;

    private Date completionDate;

    private List<String> playerValidationIds;

    ChallengePlayer(String id, String playerId, String challengeId, boolean completed, Date completionDate, List<String> playerValidationIds) {
        this(playerId, challengeId, completed, completionDate, playerValidationIds);
        this.id = id;
    }

    private ChallengePlayer(String playerId, String challengeId, boolean completed, Date completionDate, List<String> playerValidationIds) {
        this.playerId = playerId;
        this.challengeId = challengeId;
        this.completed = completed;
        this.completionDate = completionDate;
        this.playerValidationIds = playerValidationIds;
    }

    public String getId() {
        return id;
    }

    public String getChallengeId() {
        return challengeId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public List<String> getPlayerValidationIds() {
        return new ArrayList<>(playerValidationIds);
    }

    public int getNumberOfValidation() {
        return getPlayerValidationIds().size();
    }

    public ChallengePlayer validate(String playerId){
        return mutate().validate(playerId).build();
    }

    public ChallengePlayerBuilder mutate() {
        return aChallengePlayer().from(this);
    }

    boolean isCompleted() {
        return completed;
    }

    Date getCompletionDate() {
        return completionDate;
    }

}
