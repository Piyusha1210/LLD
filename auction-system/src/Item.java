import java.util.UUID;

public class Item {
    String itemId;
    String itemName;
    String itemDescription;
    Long startingPrice;


    public Item(String itemName, String description, Long startingPrice) {
        this.itemId = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.itemDescription = description;
        this.startingPrice = startingPrice;
    }
}
