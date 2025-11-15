package domain;

public class Account {
    private long cardNumber;
    private int pin;
    private String name;
    private boolean ourBranch;
    private double balance;
    private boolean isAdmin;

    public Account(long cardNumber, int pin, String name, boolean ourBranch, double balance, boolean isAdmin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.name = name;
        this.ourBranch = ourBranch;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public Account(String params) {
        String[] parts = params.split(" ");
        this(Long.parseLong(parts[0]),
                Integer.parseInt(parts[1]),
                parts[2] + " " + parts[3],
                Boolean.parseBoolean(parts[4]),
                Double.parseDouble(parts[5]),
                Boolean.parseBoolean(parts[6]));
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

    public boolean isAdmin() { return isAdmin; }

    @Override
    public String toString() {
        return name + ": "
                + (ourBranch ? "Member of our branch. " : "Not a member of our branch. ")
                + (isAdmin ? "Admin privileges. " : "Not an admin. ")
                + "Balance: " + String.format("%.2f", balance);

    }
}
