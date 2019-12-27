package com.eco.challengeservice.service;

import com.eco.challengeservice.dto.ChallengeDto;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ChallengeServiceImpl implements ChallengeService {

    @Inject
    private ChallengeConverter converter;

    @Inject
    private ChallengeRepository repository;

    @Override
    public Collection<ChallengeDto> findAll() {
        return repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
