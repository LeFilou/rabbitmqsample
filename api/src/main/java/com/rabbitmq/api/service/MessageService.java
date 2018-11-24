package com.rabbitmq.api.service;

import com.rabbitmq.dto.Request;
import com.rabbitmq.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static com.rabbitmq.constant.GenericConstants.EXCHANGE_NAME;
import static com.rabbitmq.constant.GenericConstants.ROUTING_KEY;

@Slf4j
@Service
public class MessageService {

    private final AsyncRabbitTemplate asyncRabbitTemplate;

    @Autowired
    public MessageService(AsyncRabbitTemplate asyncRabbitTemplate) {
        this.asyncRabbitTemplate = asyncRabbitTemplate;
    }

    public void sendMessage(final Request request) {
        log.info("Sending request to consumer ... : {}", request.toString());
        AsyncRabbitTemplate.RabbitConverterFuture<Response> future =
                asyncRabbitTemplate.convertSendAndReceive(EXCHANGE_NAME, ROUTING_KEY, request);

        future.addCallback(new ListenableFutureCallback<Response>() {
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(Response response) {
                log.info("Received response from consumer: {}", response.toString());
            }
        });
    }
}
