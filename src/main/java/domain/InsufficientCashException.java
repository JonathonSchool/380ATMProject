package domain;

public class InsufficientCashException extends Exception {
    public InsufficientCashException(String message) {
        super(message);
    }
}
