package com.rabbitmq.api.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rabbitmq.constant.GenericConstants.*;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    AsyncRabbitTemplate template() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(GENERIC_RESPONSE_QUEUE_NAME);
        return new AsyncRabbitTemplate(rabbitTemplate, container);
    }

    @Bean
    Exchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue requestQueue() {
        return QueueBuilder.durable(GENERIC_REQUEST_QUEUE_NAME).build();
    }

    @Bean
    Binding genericBinding() {
        return BindingBuilder.bind(requestQueue()).to(exchange()).with(ROUTING_KEY).noargs();
    }

    @Bean
    Queue responseQueue() {
        return QueueBuilder.durable(GENERIC_RESPONSE_QUEUE_NAME).build();
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
