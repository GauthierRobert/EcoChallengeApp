package com.eco.challengeuserservice.converter;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.dto.ChallengeDto;
import com.eco.challengeuserservice.dto.ChallengePlayerDto;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Named;

@Named
public class ChallengePlayerConverter {




    public ChallengePlayerDto convert(ChallengePlayer challengePlayer) {
        return convert(challengePlayer, null);
    }

    public ChallengePlayerDto convert(ChallengePlayer challengePlayer, ChallengeDto challengeDto) {
        return new ChallengePlayerDto(challengePlayer.getId(),
                                      challengePlayer.getNumberOfValidation(),
                                      challengeDto);
    }

    public Collection<ChallengePlayerDto> convert(List<ChallengePlayer> challengePlayers, Collection<ChallengeDto> challenges) {

        return challengePlayers.stream()
                               .map(challengePlayer -> convert(challengePlayer, getChallenge(challenges, challengePlayer.getChallengeId())))
                               .collect(Collectors.toList());

    }

    private ChallengeDto getChallenge(Collection<ChallengeDto> challenges, String challengeId) {
        return challenges.stream().filter(challengeDto -> challengeDto.getId().equals(challengeId)).findFirst().orElse(null);
    }

}
