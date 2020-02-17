package com.eco.challengeservice.service;

import com.eco.challengeservice.domain.Challenge;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ChallengeServiceImpl implements ChallengeService {

    @Inject
    private ChallengeRepository repository;

    @Override
    public Collection<Challenge> findAll() {
        return repository.findAll();
    }

    @Override
    public Collection<Challenge> findAllByLevel(int level) {
        return repository.findAllByLevel(level);
    }
}
