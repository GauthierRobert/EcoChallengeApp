package com.eco.challengeuserservice.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.eco.challengeuserservice.domain.ChallengePlayerBuilder.aChallengePlayer;

@Document
public class ChallengePlayer {

    @Id
    private String id;

    private String playerId;

    private String challengeId;
    //duplicate field with challenge but easier like this
    private int level;

    private int point;

    private String category;

    private boolean completed;

    private Date completionDate;

    private int validation;

    ChallengePlayer(String id, String playerId, String challengeId, int level, int point, String category, boolean completed, Date completionDate, int validation) {
        this(playerId, challengeId, level, point, category, completed, completionDate, validation);
        this.id = id;
    }

    private ChallengePlayer(String playerId, String challengeId, int level, int point, String category, boolean completed, Date completionDate, int validation) {
        this.playerId = playerId;
        this.challengeId = challengeId;
        this.level = level;
        this.point = point;
        this.category = category;
        this.completed = completed;
        this.completionDate = completionDate;
        this.validation = validation;
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

    public String getCategory() {
        return category;
    }

    public int getValidation() {
        return validation;
    }

    public ChallengePlayer validate(){
        return aChallengePlayer().from(this).validate().build();
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
