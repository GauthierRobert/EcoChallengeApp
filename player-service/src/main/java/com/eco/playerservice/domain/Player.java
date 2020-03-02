package com.eco.playerservice.domain;

import com.eco.playerservice.domain.builder.PlayerBuilder;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.eco.playerservice.domain.builder.PlayerBuilder.aPlayer;

@Document
public class Player {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userId;

    //Can be used
    private int point;
    //Cannot be used
    private int experience;

    // challengeCompleted + challengeBlocked + challengeUnBlocked = sum of all challenges
    private int completedChallenge;

    private int level;

    private List<String> contests;

    private Player() {
    }

    public Player(String id, String userId, int point, int experience, int completedChallenge, int level) {
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
