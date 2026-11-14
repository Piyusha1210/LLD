import com.supermoney.broker.MessageBroker;
import com.supermoney.broker.MessageBrokerImpl;
import com.supermoney.model.Message;
import com.supermoney.store.InMemoryMessageStore;
import com.supermoney.store.MessageStore;
import com.supermoney.subscriber.Subscriber;
import com.supermoney.subscriber.SubscriberImpl;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class MainTest {

    @Test
    void shouldNotifySubscribersConcurrently() throws Exception {

        CountDownLatch latch = new CountDownLatch(3);

        MessageStore messageStore = new InMemoryMessageStore();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MessageBroker messageBroker = new MessageBrokerImpl(messageStore, executorService);

        messageBroker.addTopic("Topic-1");

        // Create three subscribers.
        Subscriber s1 = message -> {
            latch.countDown();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
//        Subscriber s1 = new SubscriberImpl();
        Subscriber s2 = new SubscriberImpl();
        Subscriber s3 = new SubscriberImpl();

        // Each subscriber should:
        // 1. Count down the latch.
        // 2. Sleep for 2 seconds.

        // Register subscribers.
        messageBroker.addSubscriber("Topic-1", s1);
        messageBroker.addSubscriber("Topic-1", s2);
        messageBroker.addSubscriber("Topic-1", s3);

        // Publish a message.
        Message m1 = new Message("Topic-1", "Hii test message-1");
        messageBroker.publishMessage(m1);

        // Assert that all three subscribers started
        // within 1 second.
        assertTrue(latch.await(1, TimeUnit.SECONDS));
    }

}
