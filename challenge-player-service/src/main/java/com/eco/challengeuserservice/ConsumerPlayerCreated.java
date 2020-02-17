package com.eco.challengeuserservice;

import com.eco.challengeuserservice.domain.ChallengePlayer;
import com.eco.challengeuserservice.dto.ChallengeDto;
import com.eco.challengeuserservice.dto.PlayerDto;
import com.eco.challengeuserservice.proxy.ChallengeServiceProxy;
import com.eco.challengeuserservice.service.ChallengePlayerService;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.eco.challengeuserservice.domain.ChallengePlayerBuilder.aChallengePlayer;

@Service
public class ConsumerPlayerCreated {

    @Inject
    private ChallengePlayerService challengePlayerService;
    @Inject
    private ChallengeServiceProxy challengeServiceProxy;


    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.playerCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(PlayerDto payload) {
        challengePlayerService.save(getAllChallengePlayer(payload));
        latch.countDown();
    }


    private List<ChallengePlayer> getAllChallengePlayer(PlayerDto playerDto) {
        return challengeServiceProxy.findAll()
                                    .stream()
                                    .map(challengeDto -> convert(challengeDto, playerDto))
                                    .collect(Collectors.toList());
    }

    private ChallengePlayer convert(ChallengeDto challengeDto, PlayerDto playerDto) {
        return aChallengePlayer()
                .withPlayerId(playerDto.getId())
                .withChallengeId(challengeDto.getId())
                .withLevel(challengeDto.getLevel())
                .withPoint(challengeDto.getPoint())
                .withCategory(challengeDto.getCategory())
                .build();
    }

}
