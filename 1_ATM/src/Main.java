import atm.BankingService;
import atm.ATM;
import atm.Account;
import atm.Card;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------");
        BankingService bankingService = BankingService.getInstance();
        Account account1 = bankingService.crateAccount(5000);
        Account account2 = bankingService.crateAccount(3000);
        Card card1 = bankingService.crateCard(account1.getAccountID(), 1234);
        Card card2 = bankingService.crateCard(account2.getAccountID(), 5678);

        ATM atm = ATM.getInstance(bankingService);
        atm.insertCard(card1.getCardNumber());
        atm.insertCard(card2.getCardNumber());

        atm.enterPIN(2345); // INVALID pin

        atm.insertCard(card1.getCardNumber());
        atm.enterPIN(1234); // Validate PIN

        atm.checkBalance();
        atm.depositMoney(1000);

        atm.insertCard(card1.getCardNumber());
        atm.enterPIN(1234); // Validate PIN
        atm.checkBalance();
        atm.withdrawMoney(5000);

        atm.insertCard(card1.getCardNumber());
        atm.enterPIN(1234); // Validate PIN
        atm.getTransactionList();

        atm.insertCard(card1.getCardNumber());
        atm.enterPIN(1234); // Validate PIN
        atm.checkBalance();
        atm.withdrawMoney(2000); // Insufficient Balance
    }
}