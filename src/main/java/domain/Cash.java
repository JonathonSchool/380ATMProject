package domain;

public enum Cash {
    ONE(1.00),
    FIVE(5.00),
    TEN(10.00),
    TWENTY(20.00),
    FIFTY(50.00),
    HUNDRED(100.00);

    public final double value;

    Cash(double value) {
        this.value = value;
    }

}
