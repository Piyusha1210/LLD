package auctionsystem.strategy;

import auctionsystem.Auction;
import auctionsystem.enums.BidStatus;
import auctionsystem.model.Bid;

import java.util.HashMap;
import java.util.Map;

public class HighestUniqueStrategy implements AuctionStrategy{

    @Override
    public Bid getWinnerBid(Auction auction) {
        Map<String, Bid> bids = auction.getBids();

        Map<Long, Integer> frequency = new HashMap<>();
        for (Bid bid : bids.values()) {
            if (bid.getStatus() == BidStatus.ACTIVE) {
                frequency.merge(bid.getAmount(), 1, Integer::sum);
            }
        }

        Bid winner = null;
        for (Bid bid : bids.values()) {
            if (bid.getStatus() == BidStatus.ACTIVE
                    && frequency.get(bid.getAmount()) == 1 ) {
                if(winner == null || winner.getAmount() < bid.getAmount()) {
                    winner = bid;
                }
            }
        }
        return winner;
    }
}
