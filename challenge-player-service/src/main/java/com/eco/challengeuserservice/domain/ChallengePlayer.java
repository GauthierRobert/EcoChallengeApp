package com.eco.challengeuserservice.domain;

import java.lang.annotation.Documented;
import java.util.Date;

@Document
public class ChallengePlayer {

    @Id
    private String id;

    private String playerId;

    private String challengeId;

    private boolean completed;

    private Date completedDate;

}
