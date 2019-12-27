package com.eco.challengeservice.service;

import com.eco.challengeservice.domain.Challenge;
import javax.inject.Named;
import org.springframework.data.jpa.repository.JpaRepository;

@Named("challengeRepository")
interface ChallengeRepository extends JpaRepository<Challenge, Long> {


}
