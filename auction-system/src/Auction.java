import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Auction {
    private String auctionID;
    private Item item;
    private List<Bid> bidHistory;
    private Bid currentBid;
    private Long startingPrice;
    private List<String> observerID;

    public Auction(Item item, Long startingPrice) {
        this.auctionID = UUID.randomUUID().toString();
        this.item = item;
        this.startingPrice = startingPrice;
    }

    public String getAuctionID() {
        return auctionID;
    }

    private void placeBid(Bid bid) {
        if(Objects.isNull(currentBid)) {
            if(bid.getBidAmount() >= startingPrice) {
                currentBid = bid;
                bidHistory.add(bid);
            } else {
                throw new IllegalArgumentException("Bid amount must be at least the starting price.");
            }
        } else {
            if(bid.getBidAmount() > currentBid.getBidAmount()) {
                currentBid = bid;
                bidHistory.add(bid);
            } else {
                throw new IllegalArgumentException("Bid amount must be higher than the current bid.");
            }
        }
    }

    private void addObserver(String userID) {
        observerID.add(userID);
    }

    public void notifyObserver() {
        for(String observerID : observerID) {

        }
    }
}
