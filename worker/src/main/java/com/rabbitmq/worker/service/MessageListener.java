package com.rabbitmq.worker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.rabbitmq.constant.GenericConstants.GENERIC_QUEUE_NAME;

@Slf4j
@Service
public class MessageListener {

    @RabbitListener(queues = GENERIC_QUEUE_NAME)
    public void onMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }
}
