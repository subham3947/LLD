package exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("User does not exists!");
    }
    
}
