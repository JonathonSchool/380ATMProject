package domain;

public enum Coin {
    PENNY(.01, 1000),
    NICKEL(.05, 1000),
    DIME(.10, 1000),
    QUARTER(.25, 1000);

    public final double value;
    public final int minimumAmount;

    Coin(double value, int minimumAmount) {
        this.value = value;
        this.minimumAmount = minimumAmount;
    }
}
