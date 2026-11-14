package auctionsystem;

import auctionsystem.enums.Strategy;
import auctionsystem.strategy.AuctionStrategy;
import auctionsystem.strategy.HighestUniqueStrategy;

public class AuctionStrategyFactory {

    public AuctionStrategy getStrategy(Strategy strategy) {
        if(strategy == Strategy.HIGHEST_UNIQUE_BID) {
            return new HighestUniqueStrategy();
        }
        throw new IllegalArgumentException("Strategy doesn't exist");
    }
}
