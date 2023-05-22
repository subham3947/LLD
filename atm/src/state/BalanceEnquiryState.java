package state;



import atm.Atm;
import dao.AccountDetailsDao;
import user.Card;

public class BalanceEnquiryState extends State {

    AccountDetailsDao accountDetailsDao;

    public BalanceEnquiryState() {
        accountDetailsDao = AccountDetailsDao.getInstance();
    }


    public void balanceEnquiry(Atm atm, Card card){
        
        int balance = accountDetailsDao.getAccountBalance(card);
        if(balance > -1)
            System.out.println("Balance : "+balance);
        else
            System.out.println("No card details found!");

        super.exit(atm);

    }

    
}
