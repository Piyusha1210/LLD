package auctionsystem.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Seller {
    private String sellerId;
    private String sellerName;

    public Seller(String sellerName) {
        this.sellerId = UUID.randomUUID().toString();
        this.sellerName = sellerName;
    }
}
