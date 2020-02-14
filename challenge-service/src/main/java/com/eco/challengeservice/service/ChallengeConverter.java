package com.eco.challengeservice.service;

import com.eco.challengeservice.domain.Challenge;
import com.eco.challengeservice.dto.ChallengeDto;
import javax.inject.Named;

@Named
class ChallengeConverter {

    ChallengeDto convert(Challenge challenge) {
        return new ChallengeDto(challenge.getId(), challenge.getPoint(), challenge.getLevel(), challenge.getCategory().toString());
    }

}
