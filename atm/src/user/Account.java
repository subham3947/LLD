package user;

public class Account {

    String accountNumber;
    Card card;
    int accountBalance;

    public Account(String accountNumber, Card card, int accountBalance) {
        this.accountNumber = accountNumber;
        this.card = card;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

   
    
}

    
