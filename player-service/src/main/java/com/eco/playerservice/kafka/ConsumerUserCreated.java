package com.eco.playerservice.kafka;

import com.eco.playerservice.dto.UserDto;
import com.eco.playerservice.service.PlayerService;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.eco.playerservice.domain.Player.newPlayer;

@Service
public class ConsumerUserCreated {

    @Autowired
    private PlayerService playerService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(UserDto payload) {
        playerService.save(newPlayer(payload.getId()));
        latch.countDown();
    }

}
