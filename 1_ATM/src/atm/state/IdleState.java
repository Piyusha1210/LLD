package atm.state;

import atm.ATM;
import atm.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, String cardNumber) {
        Card card = atm.getCardFromBank(cardNumber);
        if(card == null) {
            System.out.println("Card doesn't found");
            ejectCard(atm);
            return;
        }
        atm.setCard(card);
        atm.setState(new CardInsertedState());
    }
}
