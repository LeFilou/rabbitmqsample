package com.rabbitmq.worker.service;

import com.rabbitmq.dto.Request;
import com.rabbitmq.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static com.rabbitmq.constant.GenericConstants.GENERIC_REQUEST_QUEUE_NAME;

@Slf4j
@Service
public class MessageListener {

    @RabbitListener(queues = GENERIC_REQUEST_QUEUE_NAME)
    public Response onMessage(@Payload final Request request) {
        log.info("Received request from producer: {}", request.toString());
        return new Response("response title", "response message");
    }
}
