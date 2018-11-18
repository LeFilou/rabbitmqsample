package com.rabbitmq.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SimpleMessage implements Serializable {
    private String message;
    private String description;
}
