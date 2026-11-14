package com.supermoney.store;

import com.supermoney.model.Message;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMessageStore implements MessageStore {

    private final Map<String, Message> messages;

    public InMemoryMessageStore() {
        messages = new ConcurrentHashMap<>();
    }

    @Override
    public void saveMessage(Message message) {
        if(message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        Message existing = messages.putIfAbsent(message.getId(), message);

        if(existing != null) {
            throw new IllegalArgumentException("Message already exists: " +  message.getId());
        }
    }

    @Override
    public Optional<Message> findById(String messageID) {
        return Optional.ofNullable(messages.get(messageID));
    }
}
