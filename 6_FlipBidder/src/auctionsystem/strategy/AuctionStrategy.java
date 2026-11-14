package auctionsystem.strategy;

import auctionsystem.Auction;
import auctionsystem.model.Bid;

public interface AuctionStrategy {
    Bid getWinnerBid(Auction auction);
}
