package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    void login(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Medewerker medewerker = authenticateMedewerker(username, password);
        if(medewerker != null) showMenuVenster(medewerker);
    }

    private Medewerker authenticateMedewerker(String username, String password) {
        for (Medewerker medewerker : Medewerker.medewerkers)
            if (medewerker.getGebruikersnaam().equals(username) && medewerker.getWachtwoord().equals(password))
                return medewerker;
        return null;
    }

    private void showMenuVenster(Medewerker medewerker) throws IOException {
        SceneController.showScene(SceneController.MENU_VIEW_PATH, SceneController.MENU_VIEW_TITLE, new Stage(), medewerker);
    }
}
