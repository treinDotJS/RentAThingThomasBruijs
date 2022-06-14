package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController implements SetMedewerker {
    private Medewerker medewerker;
    @FXML
    private Label medewerkerLabel;

    @FXML
    void logOut(ActionEvent event) {
        Stage stage = (Stage) medewerkerLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void showBeheer(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.BEHEER_VIEW, currentStage, medewerker);
    }

    @FXML
    void showOverzicht(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.OVERZICHT_VIEW, currentStage, medewerker);
    }

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
        initialize();
    }

    private void initialize() {
        medewerkerLabel.setText("Medewerker: "+medewerker.getGebruikersnaam());
    }
}
