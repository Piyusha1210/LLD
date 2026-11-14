package atm;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Card {
    String cardNumber;
    Integer pin;
    String accountID;

    Card(String accountID, Integer pin) {
        this.cardNumber = UUID.randomUUID().toString();
        this.accountID = accountID;
        this.pin = pin;
    }
}
