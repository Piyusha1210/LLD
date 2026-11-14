package com.supermoney.subscriber;

import com.supermoney.model.Message;

import java.util.UUID;

public class SubscriberImpl implements Subscriber {
    String subscriberId;

    public SubscriberImpl() {
        this.subscriberId = UUID.randomUUID().toString();
    }

    @Override
    public void onEvent(Message message) {
        System.out.println("Process message: " + message.getPayload());
    }
}
