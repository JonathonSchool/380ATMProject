package domain;

public enum Cash {
    ONE(1.00, 5000),
    FIVE(5.00, 1000),
    TEN(10.00, 1000),
    TWENTY(20.00, 1000),
    FIFTY(50.00, 750),
    HUNDRED(100.00, 750);

    public final double value;
    public final int minimumAmount;

    Cash(double value, int minimumAmount) {
        this.value = value;
        this.minimumAmount = minimumAmount;
    }

}
