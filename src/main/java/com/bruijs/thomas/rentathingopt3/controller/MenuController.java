package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
    private Medewerker medewerker;
    @FXML
    private Label medewerkerLabel;

    @FXML
    void logOut(ActionEvent event) {
        Stage stage = (Stage) medewerkerLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void showBeheer(ActionEvent event) {

    }

    @FXML
    void showOverzicht(ActionEvent event) {

    }

    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
        initialize();
    }

    private void initialize() {
        medewerkerLabel.setText("Medewerker: "+medewerker.getGebruikersnaam());
    }
}
