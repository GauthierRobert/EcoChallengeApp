package com.eco.challengeuserservice.converter;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.dto.ChallengePlayerDto;
import javax.inject.Named;
import org.springframework.core.convert.converter.Converter;

@Named
public class ChallengePlayerConverter implements Converter<ChallengePlayer, ChallengePlayerDto> {

    @Override
    public ChallengePlayerDto convert(ChallengePlayer challengePlayer) {
        return new ChallengePlayerDto(challengePlayer.getId(),
                                      challengePlayer.getChallengeId(),
                                      challengePlayer.getPlayerId(),
                                      challengePlayer.getNumberOfValidation());
    }
}
