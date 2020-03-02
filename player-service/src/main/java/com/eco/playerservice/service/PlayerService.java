package com.eco.playerservice.service;

import com.eco.playerservice.domain.Player;
import com.eco.playerservice.dto.ChallengeValidatedDto;
import com.eco.playerservice.kafka.ProducerPlayerCreated;
import com.eco.playerservice.repository.PlayerRepository;
import javax.inject.Inject;
import javax.inject.Named;

import static com.eco.playerservice.dto.builder.PlayerDtoBuilder.aPlayerDto;

@Named
public class PlayerService {

    @Inject
    private PlayerRepository playerRepository;
    @Inject
    private ProducerPlayerCreated producerPlayerCreated;

    public void save(Player player) {
        Player savedPlayer = playerRepository.save(player);
        producerPlayerCreated.sendMessage(aPlayerDto().withId(savedPlayer.getId()).build());
    }

    public void validate(ChallengeValidatedDto payload) {
        Player player = playerRepository.findById(payload.getPlayerId()).orElseThrow(() -> new RuntimeException("Player not found with id : " + payload.getPlayerId()));

        player = player.mutate().addPoint(payload.getPoint()).addCompletedChallenge().addExperience(payload.getExperience()).build();

        playerRepository.save(player);
    }
}
