package com.eco.challengeuserservice.converter;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.dto.ChallengePlayerDto;
import javax.inject.Named;
import org.springframework.core.convert.converter.Converter;

import static com.eco.challengeuserservice.dto.builder.ChallengePlayerDtoBuilder.aChallengePlayerDto;

@Named
public class ChallengePlayerConverter implements Converter<ChallengePlayer, ChallengePlayerDto> {

    @Override
    public ChallengePlayerDto convert(ChallengePlayer challengePlayer) {
        return aChallengePlayerDto().withId(challengePlayer.getId())
                                    .withChallengeId(challengePlayer.getChallengeId())
                                    .withPlayerId(challengePlayer.getPlayerId())
                                    .withValidation(challengePlayer.getNumberOfValidation())
                                    .build();
    }
}
