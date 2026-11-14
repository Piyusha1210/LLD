package atm;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Transaction {
    String txnID;
    String accountID;
    Integer amount;
    TransactionType txnType;
    LocalDateTime timeStamp;

    public Transaction (String accountID, Integer amount, TransactionType txnType) {
        this.txnID = UUID.randomUUID().toString();
        this. accountID = accountID;
        this.amount = amount;
        this.txnType = txnType;
        this.timeStamp = LocalDateTime.now();
    }
}
