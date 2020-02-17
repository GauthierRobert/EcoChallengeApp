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

    public ChallengePlayer save(ChallengePlayer challengePlayer) {
        return challengePlayerRepository.save(challengePlayer);
    }

    public void save(List<ChallengePlayer> challengePlayers) {
        challengePlayerRepository.saveAll(challengePlayers);
    }

    public List<ChallengePlayer> findByPlayerId(String playerId){
        return challengePlayerRepository.findByPlayerId(playerId);
    }

    public List<ChallengePlayer> findByPlayerIdAndLevel(String playerId, int level){
        return challengePlayerRepository.findByPlayerIdAndLevel(playerId, level);
    }

    public ChallengePlayer validate(String playerId, String challengePlayerId) {
        ChallengePlayer challengePlayer = challengePlayerRepository.findById(challengePlayerId).orElseThrow(() -> new RuntimeException("Cannot found challenge with Id : " + challengePlayerId));
        return save(challengePlayer.validate(playerId));
    }
}
