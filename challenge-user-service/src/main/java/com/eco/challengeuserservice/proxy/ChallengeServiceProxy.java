package com.eco.challengeuserservice.proxy;

import com.eco.challengeuserservice.dto.ChallengeDto;
import java.util.Collection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "challengeService", url = "http://localhost:16017")
public interface ChallengeServiceProxy {

    @GetMapping("/challenge/all")
    Collection<ChallengeDto> findAll();

}
