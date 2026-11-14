package auctionsystem;

import auctionsystem.enums.AuctionStatus;
import auctionsystem.enums.BidStatus;
import auctionsystem.enums.Strategy;
import auctionsystem.model.Bid;
import auctionsystem.model.Buyer;
import auctionsystem.model.Seller;
import auctionsystem.strategy.AuctionStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionSystem {

    private static AuctionSystem instance;
    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;
    private Map<String, Auction> auctions;
    private static final Strategy defaultStrategy = Strategy.HIGHEST_UNIQUE_BID;
    private final AuctionStrategyFactory strategyFactory;

    private AuctionSystem() {
        buyers = new ConcurrentHashMap<>();
        sellers = new ConcurrentHashMap<>();
        auctions = new ConcurrentHashMap<>();
        strategyFactory = new AuctionStrategyFactory();
    }

    public static AuctionSystem getInstance() {
        if(instance == null) {
            instance = new AuctionSystem();
        }
        return instance;
    }

    public void addBuyer(Buyer buyer) {
        Buyer existing = buyers.putIfAbsent(buyer.getBuyerId(), buyer);
        if(existing != null) {
            System.out.println("Buyer with sameId already exists");
        }
    }

    public void addSeller(Seller seller) {
        Seller existing = sellers.putIfAbsent(seller.getSellerId(), seller);
        if(existing != null) {
            System.out.println("Seller with sameId already exists");
        }
    }

    public void createAuction(Seller seller, Long minBidLimit, Long maxBidLimit, Long participationCost) {

        if(seller == null || !sellers.containsKey(seller.getSellerId())) {
            System.err.println("Seller doesn't exists");
            return;
        }

        Seller systemSeller = sellers.get(seller.getSellerId());
        Auction auction = new Auction(systemSeller, minBidLimit,maxBidLimit, participationCost);
        auctions.putIfAbsent(auction.getAuctionId(), auction);
    }

    public Bid createOrUpdateBid(Auction auction, Buyer buyer, long amount) {
        // check auction & buyer exists
        if(auction == null || !auctions.containsKey(auction.getAuctionId())) {
            System.err.println("Auction doesn't exists");
            return null;
        }
        if(buyer == null || !buyers.containsKey(buyer.getBuyerId())) {
            System.err.println("Buyer doesn't exists");
            return null;
        }

        if(!validateBid(amount, auction)){
            System.err.println("Bid validation failed");
            return null;
        }

        Auction systemAuction = auctions.get(auction.getAuctionId());
        Buyer systemBuyer = buyers.get(buyer.getBuyerId());

        Bid bid = null;
        Map<String, Bid> bids = auctions.get(systemAuction.getAuctionId()).getBids();
        if(!bids.containsKey(systemBuyer.getBuyerId())) {
            bid = new Bid(systemBuyer, amount);
            systemAuction.getBids().putIfAbsent(systemBuyer.getBuyerId(), bid);
        }
        else {
            bid = bids.get(systemBuyer.getBuyerId());
            if(bid.getStatus() == BidStatus.WITHDRAW) {
                System.err.println("Bid has withdraw, couldn't update Bid");
                return null;
            }
            bid.updateBidAmount(amount);
        }
        return bid;
    }

    public void withdrawBid(Buyer buyer, Auction auction) {
        // check auction & buyer exists
        if(auction == null || !auctions.containsKey(auction.getAuctionId())) {
            System.err.println("Auction doesn't exists");
            return;
        }
        if(buyer == null || !buyers.containsKey(buyer.getBuyerId())) {
            System.err.println("Buyer doesn't exists");
            return;
        }

        // Bug-4 validate auction status
        Auction systemAuction = auctions.get(auction.getAuctionId());
        if(systemAuction.getStatus() == AuctionStatus.COMPLETED) {
            System.err.println("Auction has already completed");
            return;
        }

        Bid bid = systemAuction.getBids().get(buyer.getBuyerId());
        if(bid == null) {
            System.err.println("Bid for buyer doesn't exists");
            return;
        }
        bid.withdrawBid();
    }

    public Bid closeAuction(Auction auction, Strategy strategy) {
        if(auction == null || !auctions.containsKey(auction.getAuctionId())) {
            System.err.println("Auction doesn't exists");
            return null;
        }
        if(strategy == null) {
            strategy = defaultStrategy;
        }

        // update auction to completed
        Auction systemAuction = auctions.get(auction.getAuctionId());
        systemAuction.closeAuction();
        AuctionStrategy auctionStrategy = strategyFactory.getStrategy(strategy);
        return auctionStrategy.getWinnerBid(systemAuction);
    }

    private boolean validateBid(long amount, Auction auction) {
        if(amount < auction.getMinBidLimit()) {
            System.err.println("Min bid amount should be greater than: " +
                    auction.getMinBidLimit());
            return false;
        }
        if(amount > auction.getMaxBidLimit()) {
            System.err.println("Max bid amount should be less than: " +
                    auction.getMaxBidLimit());
            return false;
        }
        if(auction.getStatus() == AuctionStatus.COMPLETED) {
            System.err.println("Auction has completed");
            return false;
        }

        return true;
    }

}
