package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailController implements Observer, SetMedewerker, SetProduct {
    private Medewerker medewerker;
    private Product product;
    @FXML
    private Label verhuurdLabel, detailsLabel, huurprijsLabel, klantLabel, werknemerLabel;
    @FXML
    private TextField klantTextField;
    @FXML
    private VBox retourBox, verhuurBox;
    @FXML
    private CheckBox verzekerCheckBox;

    @FXML
    void retour(ActionEvent event) {
        product.setOpVoorraad(true);
    }

    @FXML
    void verhuur(ActionEvent event) {
        product.setOpVoorraad(false);
    }

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
        initialize();
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

    private void showRetour() {
        verhuurBox.setVisible(false);
        retourBox.setVisible(true);
    }

    private void showVerhuur() {
        verzekerCheckBox.setSelected(false);
        setHuurprijs();

        verhuurBox.setVisible(true);
        retourBox.setVisible(false);
    }

    private void setHuurprijs() {
        huurprijsLabel.setText(String.format(
                "Huurprijs: €%.2f per dag",
                product.berekenHuur(1, verzekerCheckBox.isSelected())));
    }

    private void setDetails() {
        detailsLabel.setText(product.getAllDetails());
        verhuurdLabel.setText("Verhuurd: "+(product.isOpVoorraad() ? "Nee":"Ja"));
    }

    private void initialize() {
        product.attach(this);
        update();
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.OVERZICHT_VIEW_PATH, SceneController.OVERZICHT_VIEW_TITLE, currentStage, medewerker);
    }
}
