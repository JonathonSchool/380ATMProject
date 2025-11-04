package domain;

import java.time.LocalDateTime;

public class Transaction {
    private final TransactionType type;
    private final double amount;
    private final long cardNumber;
    private final LocalDateTime timestamp;

    public Transaction(TransactionType type, double amount, long cardNumber, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.timestamp = timestamp;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
