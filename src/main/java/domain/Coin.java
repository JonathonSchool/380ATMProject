package domain;

public enum Coin {
    PENNY(.01),
    NICKEL(.05),
    DIME(.10),
    QUARTER(.25);

    public final double value;

    Coin(double value) {
        this.value = value;
    }
}
