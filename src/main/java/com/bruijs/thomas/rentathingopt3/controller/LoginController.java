package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginBtn;

    @FXML
    void onLoginBtnClick(ActionEvent event) throws IOException {
        login();
    }

    private void login() throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initControls();
    }

    private void initControls() {
        addControlListeners();
        resetControls();
    }

    private void addControlListeners() {
        usernameField.textProperty().addListener((observableValue, s, t1) -> loginBtn.setDisable(!isCorrectInputLength()));
        passwordField.textProperty().addListener((observableValue, s, t1) -> loginBtn.setDisable(!isCorrectInputLength()));
    }

    private boolean isCorrectInputLength() {
        int usernameLength = usernameField.getText().trim().length();
        int passwordLength = passwordField.getText().trim().length();
        return usernameLength > 0 && passwordLength > 0;
    }

    private void resetControls() {
        usernameField.clear();
        passwordField.clear();
        loginBtn.setDisable(true);
    }
}
