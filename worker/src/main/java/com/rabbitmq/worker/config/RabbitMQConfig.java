package com.rabbitmq.worker.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import static com.rabbitmq.constant.GenericConstants.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue requestQueue() {
        return new Queue(GENERIC_REQUEST_QUEUE_NAME);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
