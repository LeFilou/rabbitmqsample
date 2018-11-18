package com.rabbitmq.api.controller;

import com.rabbitmq.api.service.MessageService;
import com.rabbitmq.dto.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody SimpleMessage simpleMessage) {
            messageService.sendMessage(simpleMessage);
    }
}
