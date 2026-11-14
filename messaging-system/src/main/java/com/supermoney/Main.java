package com.supermoney;

import com.supermoney.broker.MessageBroker;
import com.supermoney.broker.MessageBrokerImpl;
import com.supermoney.store.InMemoryMessageStore;
import com.supermoney.store.MessageStore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MessageStore messageStore = new InMemoryMessageStore();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MessageBroker messageBroker = new MessageBrokerImpl(messageStore, executorService);

        messageBroker.addTopic("Topic-1");
        messageBroker.addTopic("Topic-2");
        messageBroker.addTopic("Topic-2");

        messageBroker.shutDown();
    }
}