package com.rabbitmq.api.controller;

import com.rabbitmq.api.service.MessageService;
import com.rabbitmq.dto.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/api/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody final Request request) {
            messageService.sendMessage(request);
    }
}
