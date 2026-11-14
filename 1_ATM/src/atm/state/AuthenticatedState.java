package atm.state;

import atm.*;

import java.util.List;

public class AuthenticatedState extends ATMState{

    @Override
    public void checkBalance(ATM atm) {
        Card card = atm.getCard();
        Account account = atm.getAccountFromBank(card.getAccountID());
        System.out.println("Balance: " + account.getBalance());
    }

    @Override
    public void getTransactionList(ATM atm) {
        Card card = atm.getCard();
        Account account = atm.getAccountFromBank(card.getAccountID());
        List<Transaction> txns = account.getTransactions();
        System.out.println("TxnID   Type   Amount   Time");
        for(Transaction txn: txns) {
            System.out.println(txn.getTxnID() + "  " + txn.getTxnType() + "  " + txn.getAmount() + "  " + txn.getTimeStamp());
        }
        ejectCard(atm);
    }

    @Override
    public void withdrawMoney(ATM atm, Integer amount) {
        Card card = atm.getCard();
        BankingService bank = atm.getBankingService();
        bank.withdrawMoney(card.getAccountID(), amount);
        ejectCard(atm);
    }

    @Override
    public void depositMoney(ATM atm, Integer amount) {
        Card card = atm.getCard();
        BankingService bank = atm.getBankingService();
        bank.depositMoney(card.getAccountID(), amount);
        ejectCard(atm);
    }
}
