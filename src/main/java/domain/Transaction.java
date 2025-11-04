package domain;

public class Transaction {
    private final TransactionType type;
    private final double amount;
    private final long cardNumber;

    public Transaction(TransactionType type, double amount, long cardNumber) {
        this.type = type;
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type.name();
    }

    public long getCardNumber() {
        return cardNumber;
    }

}
