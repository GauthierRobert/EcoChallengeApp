package com.eco.challengeservice.service;

import com.eco.challengeservice.dto.ChallengeDto;
import java.util.Collection;

public interface ChallengeService {

    Collection<ChallengeDto> findAll();

}
