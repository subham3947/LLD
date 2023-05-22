package user;

import dao.AccountDetailsDao;

public class AccountController {

    
    AccountDetailsDao accountDetailsDao;

    public AccountController() {
        accountDetailsDao = AccountDetailsDao.getInstance();
    }



    public void registerAccount(Account account) {

        accountDetailsDao.addAccount(account);
    }


    
}
