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
    //duplicate field with challenge but easier like this
    private int level;

    private int point;

    private boolean completed;

    private Date completionDate;

    private List<String> playerValidationIds;

    ChallengePlayer(String id, String playerId, String challengeId, int level, int point, boolean completed, Date completionDate, List<String> playerValidationIds) {
        this(playerId, challengeId, level, point, completed, completionDate, playerValidationIds);
        this.id = id;
    }

    private ChallengePlayer(String playerId, String challengeId, int level, int point,boolean completed, Date completionDate, List<String> playerValidationIds) {
        this.playerId = playerId;
        this.challengeId = challengeId;
        this.level = level;
        this.point = point;
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

    public int getLevel() {
        return level;
    }

    public int getPoint() {
        return point;
    }

    public List<String> getPlayerValidationIds() {
        return new ArrayList<>(playerValidationIds);
    }

    public int getNumberOfValidation() {
        return getPlayerValidationIds().size();
    }

    public ChallengePlayer validate(String playerId){
        return aChallengePlayer().from(this).validate(playerId).build();
    }

    String getPlayerId() {
        return playerId;
    }

    boolean isCompleted() {
        return completed;
    }

    Date getCompletionDate() {
        return completionDate;
    }

}
