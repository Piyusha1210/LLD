package com.supermoney.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Message {
    private String id;
    private String topic;
    private String payload;
    private LocalDateTime createdAt;

    public Message(String topic, String payload) {
        this.id = UUID.randomUUID().toString();
        this.topic = Objects.requireNonNull(topic, "Topic cann't be null");
        this.payload = payload;
        this.createdAt = LocalDateTime.now();
    }
}
