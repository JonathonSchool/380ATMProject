package ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    private final Model model;
    private final Interactor interactor;
    private ViewBuilder viewBuilder;
    private final Stage stage;

    public Controller(Stage stage) {
        this.model = new Model();
        this.interactor = new Interactor(model, this);
        this.viewBuilder = new InitialLoginViewBuilder(model, interactor::processInitialLoginRequest);
        this.stage = stage;
    }

    public void setInitialLoginScreen() {
        stage.setScene(new Scene(viewBuilder.build(), 500, 500));
    }

    public void setInitialAdminScreen() {
        viewBuilder = new AdminScreenViewBuilder(model, interactor::setAtmCash, interactor::processAdminOpen);
        stage.setScene(new Scene(viewBuilder.build(), 500, 500));
    }

}
