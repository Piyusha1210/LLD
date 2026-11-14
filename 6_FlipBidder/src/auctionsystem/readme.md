# Entities
- Seller
  - id 
  - sellerName

- Buyer
  - id
  - buyerName

- Auction
  - auctionID,
  - seller
  - minPrice
  - maxPrice
  - strategy
  - status (COMPLETED | IN_PROGRESS)
  - List<Bid> bids
  - Bid leadingBid

- Bid
  - bidId 
  - buyer
  - amount

- AuctionManagementSystem