package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import atm.Atm;
import dao.AccountDetailsDao;
import user.Card;

public class WithdrawState extends State{

    AccountDetailsDao accountDetailsDao;

    public WithdrawState() {
        accountDetailsDao = AccountDetailsDao.getInstance();
    }

    public void cashWithdraw(Atm atm, Card card) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be withdrawn : ");
        int amountToBeWithdrawnByUser = sc.nextInt();
        if(atm.getAmount() >= amountToBeWithdrawnByUser){
            int amount = amountToBeWithdrawnByUser;
            Map<Integer, Integer> denomination = atm.getDenominations();
            Map<Integer, Integer> cashToBeDispensed = new HashMap<Integer, Integer>();
            List<Integer> notes = new ArrayList<>(denomination.keySet());
            Collections.sort(notes, ((a,b) -> (b - a)));
            for(Integer note : notes){
                // if(amount % note != 0){
                    int unit = amount / note;
                    amount = amount % note;
                    cashToBeDispensed.put(note, unit);
                // }
            }
            int sumToBeDispensed = 0;
            for(Integer note : cashToBeDispensed.keySet())
                sumToBeDispensed += note * (cashToBeDispensed.get(note));
            if(amountToBeWithdrawnByUser == sumToBeDispensed){
                updateAtmBalance(atm, cashToBeDispensed, amountToBeWithdrawnByUser);
                accountDetailsDao.updateAccountBalance(card, amountToBeWithdrawnByUser, false);
                System.out.println("Amount withdrawn succesfully!");
                System.out.println("Account Balance : "+accountDetailsDao.getAccountBalance(card));
            } 
            else{
                System.out.println("Notes of paticular denomination not available at this moment");
               
            }
                
        }else{
            System.out.println("Cash not available at this moment");
        }
        super.exit(atm);
        //sc.close();
    }

    private void updateAtmBalance(Atm atm, Map<Integer, Integer> cashToBeDispensed, int amountToBeWithdrawnByUser) {

        Map<Integer, Integer> denominationMap = atm.getDenominations();
        Map<Integer, Integer> denomination = new HashMap<Integer, Integer>(denominationMap);
        for(Integer note : cashToBeDispensed.keySet()){
            Integer updateNotes = denomination.get(note) - cashToBeDispensed.get(note);
            denomination.put(note, updateNotes);
        }
        atm.setDenominations(denomination);atm.setAmount(atm.getAmount() - amountToBeWithdrawnByUser);
    }


    
    
}
