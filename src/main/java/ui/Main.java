package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

//    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Test.fxml"));
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(primaryStage);
//        Scene scene = new Scene(controller.setInitialLoginScreen(), 500, 500);
//        primaryStage.setScene(scene);
        controller.setInitialLoginScreen();
        primaryStage.show();
//        Scene bootupScene = new Scene(createBootupScene(), 500, 500);
//        primaryStage.setScene(bootupScene);
//        primaryStage.show();
    }

//    public Region createBootupScene() {
//        BorderPane result = new BorderPane();
//        result.setTop(headingLabel("Admin login required to start system"));
//        result.setCenter(createLoginPanel());
//        result.setBottom(createLoginSubmitButton());
//        BorderPane.setAlignment(result.getTop(), Pos.CENTER);
//        BorderPane.setAlignment(result.getBottom(), Pos.CENTER);
//        BorderPane.setMargin(result.getTop(), new Insets(30, 0, 0, 0));
//        BorderPane.setMargin(result.getBottom(), new Insets(0, 0, 30, 0));
//        return result;
//    }
//
//    public Node createLoginPanel() {
//        VBox result = new VBox(10);
//
//        HBox cardNumberQuery = new HBox(10, createPromptLabel("Account number: "), boundTextField(cardNumberInput));
//        cardNumberQuery.setAlignment(Pos.CENTER);
//
//        HBox pinQuery = new HBox(10, createPromptLabel("PIN: "), boundTextField(pinInput));
//        pinQuery.setAlignment(Pos.CENTER);
//
//        result.getChildren().add(cardNumberQuery);
//        result.getChildren().add(pinQuery);
//        result.setAlignment(Pos.CENTER);
//
//        return result;
//    }
//
//    public Node boundTextField(StringProperty boundField) {
//        TextField result = new TextField();
//        result.textProperty().bindBidirectional(boundField);
//        return result;
//    }
//
//    public Node headingLabel(String contents) {
//        return new Label(contents);
//    }
//
//    public Node createPromptLabel(String contents) {
//        return new Label(contents);
//    }
//
//    public Node createLoginSubmitButton() {
//        Button result = new Button("Login");
//        result.setOnAction(evt -> {
//            try {
//                loginManager.login(Long.parseLong(cardNumberInput.get()), Integer.parseInt(pinInput.get()));
//                System.out.println(atm.getCurrentAccount());
//            } catch (InvalidPINException e) {
//                System.out.println(e.getMessage());
//            }
//        });
//        return result;
//    }

}
