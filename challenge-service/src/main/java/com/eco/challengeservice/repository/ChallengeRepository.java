package com.eco.challengeservice.repository;

import com.eco.challengeservice.domain.Challenge;
import java.util.Collection;
import javax.inject.Named;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Named("challengeRepository")
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("SELECT c FROM Challenge c WHERE c.level = :level")
    Collection<Challenge> findAllByLevel(@Param("level") int level);

}
