package com.eco.challengeuserservice.controller;

import com.eco.challengeuserservice.dto.ChallengeDto;
import java.util.Collection;
import javax.inject.Inject;

import com.eco.challengeuserservice.proxy.ChallengeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge-user")
public class ChallengeUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ChallengeServiceProxy challengeServiceProxy;

    @GetMapping("/")
    public Collection<ChallengeDto> findAll(){
        return challengeServiceProxy.findAll();
    }

}
