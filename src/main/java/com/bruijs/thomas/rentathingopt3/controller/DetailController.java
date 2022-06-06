package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Klant;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Verhuur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailController implements Observer, SetMedewerker, SetProduct {
    private Medewerker medewerker;
    private Product product;
    @FXML
    private Label verhuurdLabel, detailsLabel, huurprijsLabel, klantLabel, werknemerLabel, verzekerdLabel, huurprijsRetLabel;
    @FXML
    private TextField voornaamField, achternaamField;
    @FXML
    private VBox retourBox, verhuurBox;
    @FXML
    private CheckBox verzekerCheckBox;
    @FXML
    private Button verhuurButton;

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
        initialize();
    }

    private void initialize() {
        product.attach(this);
        voornaamField.textProperty().addListener((observableValue, s, t1) -> checkIfValidVerhuur());
        achternaamField.textProperty().addListener((observableValue, s, t1) -> checkIfValidVerhuur());
        verzekerCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> setHuurprijs(huurprijsLabel, verzekerCheckBox.isSelected()));
        update();
    }

    @Override
    public void update() {
        setDetails();
        if (product.isOpVoorraad()) {
            showVerhuur();
        } else {
            showRetour();
        }
    }

    private void setDetails() {
        detailsLabel.setText(product.getAllDetails());
        verhuurdLabel.setText("Verhuurd: "+(product.isOpVoorraad() ? "Nee":"Ja"));


        setVerhuurDetails();
        setRetourDetails();
    }

    private void setVerhuurDetails() {
        verzekerCheckBox.setSelected(false);
        setHuurprijs(huurprijsLabel, false);
        voornaamField.clear();
        achternaamField.clear();
        verhuurButton.setDisable(true);
    }

    private void setRetourDetails() {
        Verhuur verhuur = product.getVerhuur();
        if (verhuur != null) {
            klantLabel.setText(String.format("Klant: %s %s", verhuur.klant().voornaam(), verhuur.klant().achternaam()));
            werknemerLabel.setText("Werknemer: " + verhuur.medewerker().getGebruikersnaam());
            verzekerdLabel.setText("Verzekerd: " + (verhuur.verzekerd() ? "Ja" : "Nee"));
            setHuurprijs(huurprijsRetLabel, verhuur.verzekerd());
        }
    }

    private void setHuurprijs(Label label, boolean isVerzekerd) {
        label.setText(String.format(
                "Huurprijs: €%.2f per dag",
                product.berekenHuur(1, isVerzekerd)));
    }

    private void showRetour() {
        verhuurBox.setVisible(false);
        retourBox.setVisible(true);
    }

    private void showVerhuur() {
        verhuurBox.setVisible(true);
        retourBox.setVisible(false);
    }

    @FXML
    void retour(ActionEvent event) {
        product.retour();
    }

    @FXML
    void verhuur(ActionEvent event) {
        Klant klant = new Klant(voornaamField.getText(), achternaamField.getText());
        product.verhuur(klant, medewerker, verzekerCheckBox.isSelected());
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.OVERZICHT_VIEW_PATH, SceneController.OVERZICHT_VIEW_TITLE, currentStage, medewerker);
    }

    public void checkIfValidVerhuur() {
        int voornaamLength = voornaamField.getText().trim().length();
        int achternaamLength = achternaamField.getText().trim().length();

        verhuurButton.setDisable(!(voornaamLength>0&&achternaamLength>0));
    }
}
