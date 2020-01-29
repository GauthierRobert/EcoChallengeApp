package com.eco.playerservice.service;

import com.eco.playerservice.domain.Player;
import com.eco.playerservice.repository.PlayerRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PlayerService {

    @Inject
    private PlayerRepository playerRepository;

    public void save(Player player) {
        playerRepository.save(player);
    }
}
