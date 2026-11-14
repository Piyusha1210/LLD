package auctionsystem;

import auctionsystem.enums.AuctionStatus;
import auctionsystem.enums.Strategy;
import lombok.Getter;
import auctionsystem.model.Bid;
import auctionsystem.model.Seller;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Auction {
    private final String auctionId;
    private final Seller seller;
    private final long minBidLimit;
    private final long maxBidLimit;
    private final long participationCost;
    private final Map<String, Bid> bids;
    private AuctionStatus status;

    public Auction(Seller seller, Long minBidLimit, Long maxBidLimit, Long participationCost) {
        this.auctionId = UUID.randomUUID().toString();
        this.seller = seller;
        this.minBidLimit = minBidLimit;
        this.maxBidLimit = maxBidLimit;
        this.participationCost = participationCost;
        this.status = AuctionStatus.IN_PROGRESS;
        this.bids = new ConcurrentHashMap<>();
    }

    public void closeAuction() {
        if(status == AuctionStatus.COMPLETED) {
            System.out.println("Auction has already completed");
            return;
        }
        status = AuctionStatus.COMPLETED;
    }
}
