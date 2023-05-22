package user;

public class Card {

    String cardNumber;
    String cvv;
    String pin;

    public Card(String cardNumber, String cvv, String pin) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
}
