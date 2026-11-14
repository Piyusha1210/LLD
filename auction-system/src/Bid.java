import java.util.UUID;

public class Bid {
    String bidID;
    Long userID;
    Long auctionID;
    Long bidAmount;
    Long bidTime;

    public Bid(Long userID, Long auctionID, Long bidAmount) {
        this.bidID = String.valueOf(UUID.randomUUID());
        this.userID = userID;
        this.auctionID = auctionID;
        this.bidAmount = bidAmount;
        this.bidTime = System.currentTimeMillis();
    }

    public Long getBidAmount() {
        return bidAmount;
    }
}
