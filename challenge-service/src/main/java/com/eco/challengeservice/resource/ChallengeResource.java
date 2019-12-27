package com.eco.challengeservice.resource;

import com.eco.challengeservice.dto.ChallengeDto;
import com.eco.challengeservice.service.ChallengeService;
import java.util.Collection;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class ChallengeResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ChallengeService challengeService;

    @GetMapping("/all")
    public Collection<ChallengeDto> findAll(){
        return challengeService.findAll();
    }

}
