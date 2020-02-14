package com.eco.challengeuserservice.service;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.dto.ChallengeDto;
import com.eco.challengeuserservice.dto.PlayerDto;
import com.eco.challengeuserservice.proxy.ChallengeServiceProxy;
import com.eco.challengeuserservice.repository.ChallengePlayerRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;

import static com.eco.challengeuserservice.domain.ChallengePlayer.newChallengePlayer;

@Named
public class ChallengePlayerService {

    @Inject
    private ChallengeServiceProxy challengeServiceProxy;

    @Inject
    private ChallengePlayerRepository challengePlayerRepository;

    public void save(PlayerDto playerDto) {
        challengePlayerRepository.saveAll(getAllChallengePlayer(playerDto));
    }

    public List<ChallengePlayer> findByPlayerId(String playerId){
        return challengePlayerRepository.findByPlayerId(playerId);
    }

    private List<ChallengePlayer> getAllChallengePlayer(PlayerDto playerDto) {
        return challengeServiceProxy.findAll()
                                    .stream()
                                    .map(challengeDto -> convert(challengeDto, playerDto))
                                    .collect(Collectors.toList());
    }

    private ChallengePlayer convert(ChallengeDto challengeDto, PlayerDto playerDto) {
        return newChallengePlayer(playerDto.getId(), challengeDto.getId(), challengeDto.getLevel(), challengeDto.getPoint(), challengeDto.getCategory());
    }

}
