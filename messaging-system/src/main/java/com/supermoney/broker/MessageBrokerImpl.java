package com.supermoney.broker;

import com.supermoney.model.Message;
import com.supermoney.store.MessageStore;
import com.supermoney.subscriber.Subscriber;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

public class MessageBrokerImpl implements MessageBroker {

    private final Map<String, CopyOnWriteArrayList<Subscriber>> topicSubscribersMap;
    private final MessageStore messageStore;
    private final ExecutorService executorService;

    public MessageBrokerImpl(MessageStore messageStore,
                             ExecutorService executorService) {
        topicSubscribersMap = new ConcurrentHashMap<>();
        this.messageStore = Objects.requireNonNull(messageStore);
        this.executorService = Objects.requireNonNull(executorService);
    }

    @Override
    public void addTopic(String topic) {
        if(Objects.isNull(topic) || topic.isBlank()) {
            throw new IllegalArgumentException("Topic is null");
        }

        CopyOnWriteArrayList<Subscriber> existing =
                topicSubscribersMap.putIfAbsent(topic, new CopyOnWriteArrayList<>());

        if(existing != null) {
            throw new IllegalArgumentException("Topic already exists: " + topic);
        }
    }

    @Override
    public void addSubscriber(String topic, Subscriber subscriber) {
        if(!topicSubscribersMap.containsKey(topic)) {
            throw new IllegalArgumentException("Topic doesn't exists: " + topic);
        }

        CopyOnWriteArrayList<Subscriber> subscribers = topicSubscribersMap.get(topic);
        if(!subscribers.addIfAbsent(subscriber)) {
            throw new IllegalArgumentException("Subscriber has already subscribed to topic: " + topic);
        }
    }

    @Override
    public void removeSubscriber(String topic, Subscriber subscriber) {
        if(!topicSubscribersMap.containsKey(topic)) {
            throw new IllegalArgumentException("Topic doesn't exists: " + topic);
        }

        CopyOnWriteArrayList<Subscriber> subscribers = topicSubscribersMap.get(topic);
        if (!subscribers.remove(subscriber)) {
            throw new IllegalArgumentException(
                    "Subscriber has not subscribed to topic: " + topic
            );
        }
    }

    @Override
    public void publishMessage(Message message) {
        if(Objects.isNull(message)) {
            throw new IllegalArgumentException("Message can't be null");
        }
        if(!topicSubscribersMap.containsKey(message.getTopic())) {
            throw new IllegalArgumentException("Topic doesn't exists: " + message.getTopic());
        }

        messageStore.saveMessage(message);

        CopyOnWriteArrayList<Subscriber> subscribers = topicSubscribersMap.get(message.getTopic());
        for(Subscriber subscriber: subscribers) {
            executorService.submit(() -> {
                try {
                    subscriber.onEvent(message);
                }
                catch(Exception e) {
                    System.err.println("Subscriber failed " + e.getMessage());
                }
            });
        }
    }

    @Override
    public void shutDown() {
        System.out.println("PubSubService shutting down...");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("PubSubService shutdown complete.");
    }
}
