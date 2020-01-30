package com.eco.challengeuserservice.domain;

import java.lang.annotation.Documented;
import java.util.Date;

@Document
public class ChallengePlayer {

    @Id
    private String id;

    private String playerId;

    private String challengeId;
    //duplicate field with challenge but easier like this
    private String level;

    private boolean completed;

    private Date completedDate;

}
