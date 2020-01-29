package com.eco.playerservice.repository;

import com.eco.playerservice.domain.Player;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findByUserId(Long userId);
}