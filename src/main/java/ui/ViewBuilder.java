package ui;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.function.UnaryOperator;

public abstract class ViewBuilder implements Builder<Region> {

    protected final Model model;

    public ViewBuilder(Model model) {
        this.model = model;
    }

    @Override
    public abstract Region build();

    public Node boundTextField(StringProperty boundField) {
        TextField result = new TextField();
        result.textProperty().bindBidirectional(boundField);
        return result;
    }

    public Node boundLabel(StringProperty boundField) {
        Label result = new Label();
        result.textProperty().bindBidirectional(boundField);
        return result;
    }

    /**
     * A login text field has a binding to a StringProperty in Model,
     * and a max length: 16 for card number and 3 for PIN.
     */
    public Node loginTextField(StringProperty boundField, int maxLength) {
        Node result = boundTextField(boundField);

        UnaryOperator<TextFormatter.Change> inputFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.length() > maxLength || !newText.matches("\\d*")) {
                return null;
            }
            return change;
        };

        ((TextField) result).setTextFormatter(new TextFormatter<>(inputFilter));
        return result;
    }

}
