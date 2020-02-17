package com.eco.challengeservice.resource;

import com.eco.challengeservice.domain.Challenge;
import com.eco.challengeservice.dto.ChallengeDto;
import javax.inject.Named;

@Named
class ChallengeConverter {

    ChallengeDto convert(Challenge challenge) {
        return new ChallengeDto(challenge.getId(),
                                challenge.getTitle(),
                                challenge.getPoint(),
                                challenge.getLevel(),
                                challenge.getCategory().toString(),
                                challenge.getDescription());
    }

}