package atm.state;

import atm.ATM;

public abstract class ATMState {

    public void insertCard(ATM atm, String cardNumber) {
        System.out.println("Method Not supported");
    }

    public void enterPIN(ATM atm, Integer pin) {
        System.out.println("Method Not supported");
    }

    public void checkBalance(ATM atm) {
        System.out.println("Method Not supported");
    }

    public void getTransactionList(ATM atm) {
        System.out.println("Method Not supported");
    }

    public void withdrawMoney(ATM atm, Integer amount) {
        System.out.println("Method Not supported");
    }

    public void depositMoney(ATM atm, Integer amount) {
        System.out.println("Method Not supported");
    }

    public void ejectCard(ATM atm) {
        System.out.println("Eject Card");
        System.out.println("----------------------------");
        atm.setCard(null);
        atm.setState(new IdleState());
    }
}
