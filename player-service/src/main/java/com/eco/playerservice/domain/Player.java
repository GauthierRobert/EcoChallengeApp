package com.eco.playerservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private Integer challengeCompleted;

    private Integer level;

    private Player() {
    }

    private Player(String id, String userId, Integer point, Integer experience, Integer challengeCompleted, Integer level) {
        this.id = id;
        this.userId = userId;
        this.point = point;
        this.experience = experience;
        this.challengeCompleted = challengeCompleted;
        this.level = level;
    }

    public static Player newPlayer(String userId){
        return new Player(null, userId, 0, 0, 0, 1);
    }

    public String getId() {
        return id;
    }
}
