package atm;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    private static BankingService instance;
    private Map<String, Account> accountsMap;
    private Map<String, Card> cardMap;

    BankingService () {
        accountsMap = new HashMap<>();
        cardMap = new HashMap<>();
    }

    public static BankingService getInstance() {
        if(instance == null) {
            instance = new BankingService();
        }
        return instance;
    }

    public Account crateAccount(Integer amount) {
        Account account = new Account(amount);
        accountsMap.put(account.getAccountID(), account);
        return account;
    }

    public Card crateCard(String accountID, Integer pin) {
        Card card = new Card(accountID, pin);
        cardMap.put(card.getCardNumber(), card);
        return card;
    }

    Card getCard(String cardNumber) {
        return cardMap.get(cardNumber);
    }

    Account getAccountByAccountID(String accountID) {
        return accountsMap.get(accountID);
    }

    public Boolean depositMoney(String accountID, Integer amount) {
        Account account = accountsMap.get(accountID);
        if(account == null) {
            System.out.println("Account doesn't found");
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        createTransaction(account, amount, TransactionType.DEPOSIT);
        System.out.println("Deposit: " + amount);
        return true;
    }

    public Boolean withdrawMoney(String accountID, Integer amount) {
        Account account = accountsMap.get(accountID);
        if(account.getBalance() < amount) {
            System.out.println("Insufficient Balance");
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        createTransaction(account, amount, TransactionType.WITHDRAW);
        System.out.println("Withdraw: " + amount);
        return true;
    }

    private void createTransaction(Account account, Integer amount, TransactionType txnType) {
        Transaction txn = new Transaction(account.getAccountID(), amount, txnType);
        account.addTransaction(txn);
    }

    public void depositCashInATM(Integer denomination, Integer count) {
    }
}
