package state;

import atm.Atm;
import user.Card;

public class CardInsertedState extends State {

    public void userAuthentication(Atm atm, Card card, String pinEnteredByTheUser){
        

        //if authenticaton successfull then change state to SelectTransactionState
        if(card.getPin().equals(pinEnteredByTheUser)){
            atm.setCurrentState(new SelectTransactionState());
            atm.getCurrentState().selectTransactionType(atm, card);
        }
        else{
            System.out.println("Pin doesn't match");
            super.exit(atm);
        }
        
    }

}
