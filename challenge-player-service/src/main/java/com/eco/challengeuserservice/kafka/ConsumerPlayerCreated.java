package com.eco.challengeuserservice.kafka;

import com.eco.challengeuserservice.dto.PlayerDto;
import com.eco.challengeuserservice.service.ChallengePlayerService;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerPlayerCreated {

    @Inject
    private ChallengePlayerService challengePlayerService;



    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.playerCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(PlayerDto payload) {

        latch.countDown();
    }
}
