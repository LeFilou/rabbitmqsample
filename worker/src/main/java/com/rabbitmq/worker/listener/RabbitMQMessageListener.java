package com.rabbitmq.worker.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@Slf4j
public class RabbitMQMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.info("Message received: [{}]", new String(message.getBody()));
    }
}
