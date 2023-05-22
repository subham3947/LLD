package state;

import atm.Atm;
import user.Card;

public abstract class State {
    
    public void userAuthentication(Atm atm, Card card, String pinEnteredByTheUser){}

    public void exit(Atm atm){

        removeCard();
        setCurrentState(atm);
    }

    public void removeCard(){
        System.out.println("Please take your card!");
    }

    public void setCurrentState(Atm atm){
        atm.setCurrentState(new IdleState());
    }

    public void selectTransactionType(Atm atm, Card card) {
    }

    public void cashWithdraw(Atm atm, Card card) {
    }

    public void cashDeposit(Atm atm, Card card) {
    }

    public void balanceEnquiry(Atm atm, Card card) {
    }

}
