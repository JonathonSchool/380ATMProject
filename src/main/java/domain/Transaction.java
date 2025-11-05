package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

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

    /**
     * Since DatabaseManager.getTransactions() return an ArrayList<String>
     * of Strings that contain the parameters for a Transaction instance,
     * this constructor takes a String formatted as
     * "transaction_type amount card_number timestamp"
     * which is the format of the Strings provided by getTransactions()
     */
    public Transaction(String params) {
        String[] parts = params.split(" ");
        this(TransactionType.valueOf(parts[0].toUpperCase()),
            Double.parseDouble(parts[1]),
            Long.parseLong(parts[2]),
            LocalDateTime.parse(parts[3]));
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

    /**
     * Returns a well-formatted LocalDateTime in String form
     * suitable for printing.
     */
    public String getTimestampFormatted() {
        return timestamp.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && cardNumber == that.cardNumber && type == that.type && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(type);
        result = 31 * result + Double.hashCode(amount);
        result = 31 * result + Long.hashCode(cardNumber);
        result = 31 * result + Objects.hashCode(timestamp);
        return result;
    }

    public String toString() {
        return String.format( getType() + ": $%.2f on " + getTimestampFormatted() , getAmount());
    }
}
