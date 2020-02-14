package com.eco.challengeuserservice.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private Date completedDate;

    private int validation;

    private ChallengePlayer(String id, String playerId, String challengeId, int level,  int point, String category,  boolean completed, Date completedDate, int validation) {
        this(playerId, challengeId, level, point, category, completed, completedDate, validation);
        this.id = id;
    }

    private ChallengePlayer(String playerId, String challengeId, int level, int point, String category, boolean completed, Date completedDate, int validation) {
        this.playerId = playerId;
        this.challengeId = challengeId;
        this.level = level;
        this.point = point;
        this.category = category;
        this.completed = completed;
        this.completedDate = completedDate;
        this.validation = validation;
    }

    public static ChallengePlayer newChallengePlayer(String playerId, String challengeId, int level, int point,  String category){
        return new ChallengePlayer(playerId, challengeId, level, point, category, false, null, 0);
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
}
