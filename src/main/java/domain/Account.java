package domain;

public class Account {
    private long cardNumber;
    private int pin;
    private String name;
    private boolean ourBranch;
    private double balance;

    public Account(long cardNumber, int pin, String name, boolean ourBranch, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.name = name;
        this.ourBranch = ourBranch;
        this.balance = balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public boolean isOurBranch() {
        return ourBranch;
    }

    public double getBalance() {
        return balance;
    }
}
