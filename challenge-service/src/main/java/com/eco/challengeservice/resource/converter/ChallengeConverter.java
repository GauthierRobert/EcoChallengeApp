package com.eco.challengeservice.resource.converter;

import com.eco.challengeservice.domain.Challenge;
import com.eco.challengeservice.dto.ChallengeDto;
import javax.inject.Named;

import static com.eco.challengeservice.dto.builder.ChallengeDtoBuilder.aChallengeDto;

@Named
public class ChallengeConverter {

    public ChallengeDto convert(Challenge challenge) {
        return aChallengeDto().withId(challenge.getId())
                              .withTitle(challenge.getTitle())
                              .withPoint(challenge.getPoint())
                              .withLevel(challenge.getLevel())
                              .withCategory(challenge.getCategory().toString())
                              .withDescription(challenge.getDescription())
                              .build();
    }

}
