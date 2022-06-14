package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        String username = usernameField.getText();
        String password = passwordField.getText();

        Medewerker medewerker = findMedewerker(username, password);
        if(medewerkerExists(medewerker))
            if(!isMedewerkerActive(medewerker))
                login(medewerker);
    }

    private boolean isMedewerkerActive(Medewerker medewerker) {
        if (medewerker.isActive()) {
            showErrorDialog("Deze gebruiker is al actief.");
            return true;
        }
        return false;
    }

    private boolean medewerkerExists(Medewerker medewerker) {
        if(medewerker == null) {
            showErrorDialog("De gebruikersnaam en/of het wachtwoord klopt niet.");
            return false;
        }
        return true;
    }

    private void login(Medewerker medewerker) throws IOException {
        resetControls();
        medewerker.setActive(true);
        showMenuVenster(medewerker);
    }

    private void showErrorDialog(String description) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ongeldige login");
        alert.setHeaderText("Ongeldige login!");
        alert.setContentText(description);

        alert.showAndWait();
    }

    private Medewerker findMedewerker(String username, String password) {
        for (Medewerker medewerker : Medewerker.medewerkers)
            if (medewerker.getGebruikersnaam().equals(username) && medewerker.getWachtwoord().equals(password))
                return medewerker;
        return null;
    }

    private boolean isCorrectInputLength() {
        int usernameLength = usernameField.getText().length();
        int passwordLength = passwordField.getText().length();
        return usernameLength > 0 && passwordLength > 0;
    }

    private void showMenuVenster(Medewerker medewerker) throws IOException {
        Stage stage = new Stage();
        stage.setOnCloseRequest(windowEvent -> stage.close());
        stage.setOnHidden(windowEvent -> medewerker.setActive(false));
        SceneController.showScene(SceneController.MENU_VIEW, stage, medewerker);
    }

    private void addControlListeners() {
        usernameField.textProperty().addListener((observableValue, s, t1) -> loginBtn.setDisable(!isCorrectInputLength()));
        passwordField.textProperty().addListener((observableValue, s, t1) -> loginBtn.setDisable(!isCorrectInputLength()));
    }

    private void resetControls() {
        usernameField.clear();
        passwordField.clear();
        loginBtn.setDisable(true);
    }

    private void initControls() {
        addControlListeners();
        resetControls();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initControls();
    }
}
