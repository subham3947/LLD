package state;

import atm.Atm;

public class IdleState extends State {

    public void insertCard(Atm atm){
        atm.setCurrentState(new CardInsertedState());
    }

    
} 
