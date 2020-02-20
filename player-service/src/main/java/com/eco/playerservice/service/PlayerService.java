package com.eco.playerservice.service;

import com.eco.playerservice.domain.Player;
import com.eco.playerservice.dto.ChallengeValidatedDto;
import com.eco.playerservice.dto.PlayerDto;
import com.eco.playerservice.kafka.ProducerPlayerCreated;
import com.eco.playerservice.repository.PlayerRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PlayerService {

    @Inject
    private PlayerRepository playerRepository;
    @Inject
    private ProducerPlayerCreated producerPlayerCreated;

    public void save(Player player) {
        Player save = playerRepository.save(player);
        producerPlayerCreated.sendMessage(new PlayerDto(save.getId()));
    }

    public void validate(ChallengeValidatedDto payload) {
        Player player = playerRepository.findById(payload.getPlayerId()).orElseThrow(() -> new RuntimeException("Player not found with id : " + payload.getPlayerId()));

        player = player.mutate().addPoint(payload.getPoint()).addCompletedChallenge().addExperience(payload.getExperience()).build();

        playerRepository.save(player);
    }
}
