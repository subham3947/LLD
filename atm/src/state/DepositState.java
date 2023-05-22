package state;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import atm.Atm;
import dao.AccountDetailsDao;
import user.Card;

public class DepositState extends State{

    AccountDetailsDao accountDetailsDao;

    public DepositState() {
        accountDetailsDao = AccountDetailsDao.getInstance();
    }

    public void cashDeposit(Atm atm, Card card){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of notes of 2000 : ");
        int twoThousandNotes = sc.nextInt();
        System.out.println("Enter no. of notes of 500 : ");
        int fiveHundredNotes = sc.nextInt();
        System.out.println("Enter no. of notes of 200 : ");
        int twoHundredNotes = sc.nextInt();
        System.out.println("Enter no. of notes of 100 : ");
        int oneHundredNotes = sc.nextInt();

        int totalAmountDeposited = 2000 * twoThousandNotes + 500 * fiveHundredNotes + 200 * twoHundredNotes + 100 * oneHundredNotes;
        accountDetailsDao.updateAccountBalance(card, totalAmountDeposited, true);
        addDenominationsToTheAtm(atm, twoThousandNotes ,fiveHundredNotes , twoHundredNotes , oneHundredNotes);
        atm.setAmount(atm.getAmount() + totalAmountDeposited);
        System.out.println("Cash deposited successfully!");
        System.out.println("Account Balance : "+accountDetailsDao.getAccountBalance(card));
        super.exit(atm);
    }

    private void addDenominationsToTheAtm(Atm atm, Integer twoThousandNotes, Integer fiveHundredNotes, Integer twoHundredNotes,
            int oneHundredNotes) {
        Map<Integer, Integer> cashDeposited = Map.of(
                    2000, twoThousandNotes,
                    500, fiveHundredNotes,
                    200, twoHundredNotes,
                    100, oneHundredNotes
                );
        Map<Integer, Integer> denominationsMap  = atm.getDenominations();
        Map<Integer, Integer> mutableMap = new HashMap<>(denominationsMap);
        
        for(Integer note : cashDeposited.keySet()){
            Integer updateNotes = mutableMap.get(note) + cashDeposited.get(note);
            mutableMap.put(note, updateNotes);
        }
        atm.setDenominations(mutableMap);
        //System.out.println(denominationsMap.get(2000) + twoThousandNotes);

        //denominationsMap.put(2000, denominationsMap.get(2000) + twoThousandNotes.intValue());
        // denominationsMap.put(500, denominationsMap.get(500) + fiveHundredNotes);
        // denominationsMap.put(200, denominationsMap.get(200) + twoHundredNotes);
        // denominationsMap.put(100, denominationsMap.get(100) + oneHundredNotes);
        //atm.setDenominations(denominationsMap);    
    }
    
}
