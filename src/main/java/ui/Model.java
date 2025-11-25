package ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

    private final StringProperty cardNumberInput = new SimpleStringProperty("");
    private final StringProperty pinInput = new SimpleStringProperty("");
    private final StringProperty atmCash = new SimpleStringProperty("");

    protected String getCardNumberInput() {
        return cardNumberInput.get();
    }

    protected void setCardNumberInput(String value) {
        cardNumberInput.set(value);
    }

    protected StringProperty cardNumberInputProperty() {
        return cardNumberInput;
    }

    protected String getPinInput() {
        return pinInput.get();
    }

    protected void setPinInput(String value) {
        pinInput.set(value);
    }

    protected StringProperty pinInputProperty() {
        return pinInput;
    }

    protected String getAtmCash() {
        return atmCash.get();
    }

    protected StringProperty atmCashProperty() {
        return atmCash;
    }

    protected void setAtmCash(String value) {
        atmCash.set(value);
    }

}
