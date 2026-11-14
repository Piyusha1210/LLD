package auctionsystem.model;

import auctionsystem.enums.BidStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Bid {
    private String bidID;
    private Buyer buyer;
    private BidStatus status;
    private long amount;

    public Bid(Buyer buyer, long amount) {
        this.bidID = UUID.randomUUID().toString();
        this.buyer = buyer;
        this.amount = amount;
        this.status = BidStatus.ACTIVE;
    }

    public void updateBidAmount(long amount) {
        this.amount = amount;
    }

    public void withdrawBid() {
        if(status == BidStatus.WITHDRAW) {
            System.err.println("Bid has already been withdraw");
            return;
        }
        this.status = BidStatus.WITHDRAW;
    }
}
