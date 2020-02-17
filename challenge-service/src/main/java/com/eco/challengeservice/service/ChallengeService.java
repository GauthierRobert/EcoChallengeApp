package com.eco.challengeservice.service;

import com.eco.challengeservice.domain.Challenge;
import java.util.Collection;

public interface ChallengeService {

    Collection<Challenge> findAll();

    Collection<Challenge> findAllByLevel(int level);

}
