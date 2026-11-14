package auctionsystem.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Buyer {
    private String buyerId;
    private String buyerName;

    public Buyer(String buyerName) {
        this.buyerId = UUID.randomUUID().toString();
        this.buyerName = buyerName;
    }
}
