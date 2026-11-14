package com.supermoney.store;

import com.supermoney.model.Message;

import java.util.Optional;

public interface MessageStore {
    void saveMessage(Message message);

    Optional<Message> findById(String messageID);
}
