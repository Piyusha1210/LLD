package com.supermoney.broker;

import com.supermoney.model.Message;
import com.supermoney.subscriber.Subscriber;

public interface MessageBroker {

    public void addTopic(String topic);

    public void addSubscriber(String topic, Subscriber subscriber);

    public void removeSubscriber(String topic, Subscriber subscriber);

    public void publishMessage(Message message);

    public void shutDown();
}
