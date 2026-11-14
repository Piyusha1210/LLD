package atm.state;

import atm.ATM;
import atm.Card;

import java.util.Objects;

public class CardInsertedState extends ATMState{

    @Override
    public void enterPIN(ATM atm, Integer pin) {
        Card card = atm.getCard();
        if(!Objects.equals(card.getPin(), pin)) {
            System.out.println("Pin doesn't match");
            ejectCard(atm);
            return;
        }
        atm.setState(new AuthenticatedState());
    }
}
