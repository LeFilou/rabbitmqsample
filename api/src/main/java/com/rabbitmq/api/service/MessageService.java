package com.rabbitmq.api.service;

import com.rabbitmq.dto.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rabbitmq.constant.GenericConstants.EXCHANGE_NAME;
import static com.rabbitmq.constant.GenericConstants.ROUTING_KEY;

@Slf4j
@Service
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(final SimpleMessage simpleMessage) {
        log.info("Sending message... : {}", simpleMessage.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, simpleMessage);
    }
}
