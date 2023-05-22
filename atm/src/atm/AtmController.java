package atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import dao.AccountDetailsDao;
import state.CardInsertedState;
import state.IdleState;
import user.Account;
import user.Card;

public class AtmController {
    Atm atm;
    AccountDetailsDao accountDetailsDao;

    public void initialize(){
        accountDetailsDao = AccountDetailsDao.getInstance();
        if(atm == null){
            atm = Atm.getAtmObject();
            loadCash();
        }
        atm.setCurrentState(new IdleState());
    }

    private void loadCash() {
        Map<Integer, Integer> denomination = Map.of(
            2000, 2,
            500, 1,
            200, 2,
            100, 1
        );
        int amount = 0;
        for (Integer key : denomination.keySet()) {
            amount +=   key * denomination.get(key);
        }
        atm.setDenominations(denomination);
        atm.setAmount(amount);
    }

    public void insertCard(Card card) {
        if(atm != null && atm.getCurrentState() instanceof IdleState){
            atm.setCurrentState(new CardInsertedState());
            String pinEnteredByTheUser = "0927";
            atm.getCurrentState().userAuthentication(atm, card, pinEnteredByTheUser);
        }else{
            System.out.println("ATM is Busy, please wait");
        }
    }

    // public void performCashWithdrawal(Card card, int amountToBeWithdrawn) {
    //     if(atm.isCashAvailable && accountHasSufficientBalance(card, amountToBeWithdrawn)){
    //         atm.getCurrentState().cashWithdraw(atm, card, amountToBeWithdrawn);
    //     }else{
    //         System.out.println("Insufficiecnt Balance!");
    //         atm.setCurrentState(new IdleState());
    //     }
    // }

    public boolean accountHasSufficientBalance(Card card, int amountToBeWithdrawn){
        int accountBalance = accountDetailsDao.getAccountBalance(card);
        if(accountBalance >= amountToBeWithdrawn)
            return true;
        return false;
    }

    
    
}
