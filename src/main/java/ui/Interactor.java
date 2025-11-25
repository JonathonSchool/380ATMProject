package ui;

import database.DatabaseManager;
import domain.ATM;
import domain.InvalidPINException;
import domain.LoginManager;

public class Interactor {

    private final Model model;
    private final Controller controller;
    private final ATM atm;
    private final LoginManager loginManager;

    public Interactor(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
        DatabaseManager dbManager = new DatabaseManager();
        atm = new ATM(new DatabaseManager());
        loginManager = new LoginManager(atm, dbManager);
    }

    public void processInitialLoginRequest() {
        if (model.getCardNumberInput().isBlank() || model.getPinInput().isBlank()) {
            return;
        }

        long cardNumber = Long.parseLong(model.getCardNumberInput());
        int pin = Integer.parseInt(model.getPinInput());

        model.setCardNumberInput("");
        model.setPinInput("");

        try {
            loginManager.login(cardNumber, pin);
            if (!atm.getCurrentAccount().isAdmin()) {
                System.out.println("Admin login is required to initialize the ATM. Please contact a bank administrator.");
                return;
            }

            model.setAtmCash(atm.toString());
            controller.setInitialAdminScreen();
        } catch (IllegalArgumentException | InvalidPINException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAtmCash() {
        atm.initializeMoney();
        model.setAtmCash(atm.toString());
    }

    public void processAdminOpen() {
        /* if (ATM cash was initialized) {
                continue to main login screen
            }
            else {
                print error on screen
            }
         */
    }

}
