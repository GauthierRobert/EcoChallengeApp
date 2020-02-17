package com.eco.challengeuserservice.repository;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengePlayerRepository extends MongoRepository<ChallengePlayer, String> {

    List<ChallengePlayer> findByPlayerId(String playerId);

    List<ChallengePlayer> findByPlayerIdAndLevel(String playerId, int level);
}