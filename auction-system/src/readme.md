# AuctionSystem

# entities.User
- userName
- userId
- email
- password

+ registerUser(String userName, String email, String password)
+ loginUser(String userName, String password)


# Item
- Long itemId
- String itemName
- String itemDescription
- Long startingPrice


Item(String itemName, String itemDescription, Long startingPrice, Long auctionEndTime) {
    this.itemId = generateUniqueId();
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.startingPrice = startingPrice;
    this.auctionEndTime = auctionEndTime;
    this.currentBid = null;
    this.bidHistory = new ArrayList<>();
}


# Bid
- userId
- bidAmount
- bidTime
- itemId

bidItem(userId, itemId, bidAmount)

# Auction

- List<Bid> bidHistory
- Long auctionEndTime

+ getCurrentBid()
+ placeBid()






