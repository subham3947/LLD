package state;

import java.util.Scanner;

import atm.Atm;
import enums.TransactionTypes;
import user.Card;

public class SelectTransactionState extends State{

    public void selectTransactionType(Atm atm, Card card) {

        //TransactionTypes transactionType = TransactionTypes.BALANCE_ENQUIRY;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice :-\n 1.Withdraw \n 2.Balance Enquiry \n 3.Deposit");
        int choice = sc.nextInt();
        //while(choice >= 1 && choice <= 3){

            switch(choice){
                case 1 :
                     
                     atm.setCurrentState(new WithdrawState());
                     atm.getCurrentState().cashWithdraw(atm, card);
                    break;
                case 2:
                    atm.setCurrentState(new BalanceEnquiryState());
                    atm.getCurrentState().balanceEnquiry(atm, card);
                    break;
                case 3:
                    //  System.out.println("Enter amount to be deposited : ");
                    //  amount = sc.nextInt();
                     atm.setCurrentState(new DepositState());
                     atm.getCurrentState().cashDeposit(atm, card);
                    break;
                default:
                    break;
                    
            }
        //     System.out.println("Enter your choice :-\n 1.Withdraw \n 2.Balance Enquiry \n 3.Deposit");
        //     choice = sc.nextInt();
        // }
        sc.close();
    }

    
}
