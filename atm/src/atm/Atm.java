package atm;


import java.util.Map;

import state.IdleState;
import state.State;

public class Atm {

    State currentState;
    int amount;
    Map<Integer, Integer> denominations;
    boolean isCashAvailable;
    static Atm atmObject;
    private Atm(){};
    

    public static Atm getAtmObject(){
        if(atmObject == null){
            atmObject = new Atm();
            atmObject.setCurrentState(new IdleState());
        }
        return atmObject;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Map<Integer,Integer> getDenominations() {
        return this.denominations;
    }

    public void setDenominations(Map<Integer,Integer> denominations) {
        this.denominations = denominations;
    }

    public boolean isIsCashAvailable() {
        return this.isCashAvailable;
    }

    public boolean getIsCashAvailable() {
        return this.isCashAvailable;
    }

    public void setIsCashAvailable(boolean isCashAvailable) {
        this.isCashAvailable = isCashAvailable;
    }
   
    
}
