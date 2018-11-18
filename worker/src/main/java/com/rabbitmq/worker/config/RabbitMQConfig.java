package com.rabbitmq.worker.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import static com.rabbitmq.constant.GenericConstants.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    Exchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue genericqueue() {
        return new Queue(GENERIC_QUEUE_NAME);
    }

    @Bean
    Binding genericbinding() {
        return BindingBuilder.bind(genericqueue()).to(exchange()).with(ROUTING_KEY).noargs();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

}
