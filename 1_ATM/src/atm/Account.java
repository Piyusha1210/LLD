package atm;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Account {
    private String accountID;
    private Integer balance;
    private List<Transaction> transactions;

    Account(Integer balance) {
        this.accountID = UUID.randomUUID().toString();
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction txn) {
        transactions.add(txn);
    }
}
