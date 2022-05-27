package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Medewerker medewerker = authenticateMedewerker(username, password);
        if(medewerker != null) {
            System.out.println("Welkom "+medewerker.getGebruikersnaam());
            showMenuVenster(medewerker);
        }
    }

    private Medewerker authenticateMedewerker(String username, String password) {
        for (Medewerker medewerker : Medewerker.medewerkers)
            if (medewerker.getGebruikersnaam().equals(username) && medewerker.getWachtwoord().equals(password))
                return medewerker;
        return null;
    }

    private void showMenuVenster(Medewerker medewerker) {
    }
}
