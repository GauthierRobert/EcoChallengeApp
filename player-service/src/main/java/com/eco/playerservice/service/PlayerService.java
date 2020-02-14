package com.eco.playerservice.service;

import com.eco.playerservice.ProducerPlayerCreated;
import com.eco.playerservice.domain.Player;
import com.eco.playerservice.dto.PlayerDto;
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
}
