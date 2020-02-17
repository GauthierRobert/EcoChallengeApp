package com.eco.challengeuserservice.service;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.repository.ChallengePlayerRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ChallengePlayerService {

    @Inject
    private ChallengePlayerRepository challengePlayerRepository;

    public void save(ChallengePlayer challengePlayer) {
        challengePlayerRepository.save(challengePlayer);
    }

    public void save(List<ChallengePlayer> challengePlayers) {
        challengePlayerRepository.saveAll(challengePlayers);
    }

    public List<ChallengePlayer> findByPlayerId(String playerId){
        return challengePlayerRepository.findByPlayerId(playerId);
    }

    public ChallengePlayer validate(String challengePlayerId) {
        ChallengePlayer challengePlayer = challengePlayerRepository.findById(challengePlayerId).orElseThrow(() -> new RuntimeException("Cannot found challenge with Id : " + challengePlayerId));
        return challengePlayerRepository.save(challengePlayer.validate());
    }
}
