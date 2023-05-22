package dao;

import java.util.HashMap;
import java.util.Map;

import user.Account;
import user.Card;

public class AccountDetailsDao {

    static AccountDetailsDao accountDetailsDao;
    Map<String, Account> accountDetailsMap = new HashMap<String, Account>();

    private AccountDetailsDao(){}

    public static AccountDetailsDao getInstance(){
        if(accountDetailsDao == null){
            accountDetailsDao = new AccountDetailsDao();
        }
        return accountDetailsDao;
    }

    public void addAccount(Account account) {

        if(!accountDetailsMap.containsKey(account)){
            accountDetailsMap.put(account.getCard().getCardNumber(), account);
        }
    }

    public void updateAccountBalance(Card card, int withdrawnAmount, boolean credit) {

        String cardNumber = card.getCardNumber();
        Account account = accountDetailsMap.get(cardNumber);
        if(credit)
            account.setAccountBalance(account.getAccountBalance() + withdrawnAmount);
        else
            account.setAccountBalance(account.getAccountBalance() - withdrawnAmount);
        accountDetailsMap.put(cardNumber, account);
    }

    public int getAccountBalance(Card card) {
        String cardNumber = card.getCardNumber();
        if(accountDetailsMap.containsKey(cardNumber)){
            Account account = accountDetailsMap.get(cardNumber);
            return account.getAccountBalance();
        }
        
        return -1;
    }


    
}
