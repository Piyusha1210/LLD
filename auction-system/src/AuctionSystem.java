import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionSystem {
    private Map<String, User> users;
    private Map<String, Auction> auctions;
    private AuctionSystem instance;

    public AuctionSystem() {
        this.users = new HashMap<>();
        this.auctions = new HashMap<>();
    }

    private AuctionSystem getAuctionSystemInstance() {
        if(instance == null) {
            instance = new AuctionSystem();
        }
        return instance;
    }

    public List<Auction> getAuctions() {
        return auctions.values().stream().toList();
    }

    public void addAuction(Auction auction) {
        auctions.put(auction.getAuctionID(), auction);
    }

}
