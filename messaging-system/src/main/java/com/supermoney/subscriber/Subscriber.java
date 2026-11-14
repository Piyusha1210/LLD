package com.supermoney.subscriber;

import com.supermoney.model.Message;

public interface Subscriber {
    void onEvent(Message message);
}
