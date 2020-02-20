package com.eco.playerservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.eco.playerservice.domain.PlayerBuilder.*;

@Document
public class Player {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userId;

    //Can be used
    private Integer point;
    //Cannot be used
    private Integer experience;

    // challengeCompleted + challengeBlocked + challengeUnBlocked = sum of all challenges
    private Integer completedChallenge;

    private Integer level;

    private Player() {
    }

    public Player(String id, String userId, Integer point, Integer experience, Integer completedChallenge, Integer level) {
        this.id = id;
        this.userId = userId;
        this.point = point;
        this.experience = experience;
        this.completedChallenge = completedChallenge;
        this.level = level;
    }

    public static Player newPlayer(String userId){
        return aPlayer().withUserId(userId).build();
    }

    public PlayerBuilder mutate(){
        return aPlayer().from(this);
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getPoint() {
        return point;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getCompletedChallenge() {
        return completedChallenge;
    }

    public Integer getLevel() {
        return level;
    }
}
