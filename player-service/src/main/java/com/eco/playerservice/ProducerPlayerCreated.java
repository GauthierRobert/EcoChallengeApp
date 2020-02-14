package com.eco.playerservice;

import com.eco.playerservice.dto.PlayerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerPlayerCreated {

    private static final Logger logger = LoggerFactory.getLogger(ProducerPlayerCreated.class);

    @Value("${spring.kafka.topic.playerCreated}")
    private String PLAYER_CREATED_TOPIC;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(PlayerDto player) {
        logger.info(String.format("#### -> Producing message -> %s", player.getId()));
        this.kafkaTemplate.send(PLAYER_CREATED_TOPIC,  player);
    }
}