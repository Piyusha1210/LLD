package atm;

import atm.state.ATMState;
import atm.state.IdleState;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ATM {
    private static ATM instance;
    private ATMState state;
    private BankingService bankingService;
    private Card card;

    private ATM(BankingService bankingService) {
        this.state = new IdleState();
        this.bankingService = bankingService;
        card = null;
    }

    public static ATM getInstance(BankingService bankingService) {
        if(instance == null) {
            instance = new ATM(bankingService);
        }
        return instance;
    }

    public Card getCardFromBank(String cardNumber) {
        return bankingService.getCard(cardNumber);
    }

    public Account getAccountFromBank(String accountID) {
        return bankingService.getAccountByAccountID(accountID);
    }

    public void insertCard(String cardNumber) {
        state.insertCard(this, cardNumber);
    }

    public void enterPIN(Integer pin) {
        state.enterPIN(this, pin);
    }

    public void checkBalance() {
        state.checkBalance(this);
    }

    public void getTransactionList() {
        state.getTransactionList(this);
    }

    public void withdrawMoney(Integer amount) {
        state.withdrawMoney(this, amount);
    }

    public void depositMoney(Integer amount) {
        state.depositMoney(this, amount);
    }

    public void ejectCard() {
        state.ejectCard(this);
    }
}
