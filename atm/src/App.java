import atm.AtmController;
import user.Account;
import user.AccountController;
import user.Card;

public class App {
    public static void main(String[] args) throws Exception {
        AccountController accountController = new AccountController();
        Card card1 = new Card("45648987176209876", "654", "0927");
        Account account = new Account("986765234", card1, 2400);
        accountController.registerAccount(account);
        System.out.println("User registered");
        AtmController atmController = new AtmController();
        
        atmController.initialize();
        System.out.println("Atm initialized");
        atmController.insertCard(card1);
        //atmController.performCashWithdrawal(card1, 1200);

    }
}
