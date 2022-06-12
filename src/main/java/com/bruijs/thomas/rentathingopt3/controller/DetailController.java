package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Klant;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.node.DetailsBox;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.Verhuur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailController implements Observer, SetMedewerker, SetProduct {
    private Medewerker medewerker;
    private Product product;
    @FXML
    private Label huurprijsLabel;
    @FXML
    private TextField voornaamField, achternaamField;
    @FXML
    private VBox verhuurBox, verhuurDetailsBox, productDetailsBox;
    @FXML
    public HBox retourButtonBox;
    @FXML
    private CheckBox verzekerCheckBox;
    @FXML
    private Button verhuurButton;

    private void setBoxes() {
        setProductDetailsBox();
        setVerhuurDetailsBox();
        setVerhuurBox();
    }

    private void setVerhuurDetailsBox() {
        verhuurDetailsBox.getChildren().clear();
        DetailsBox dBox = new DetailsBox(Verhuur.getDetails(product.getVerhuur()));
        dBox.setAlignment(Pos.CENTER);
        Label isVerhuurdLabel = (Label) dBox.getChildren().get(0);
        isVerhuurdLabel.setOpaqueInsets(new Insets(0,0,10,0));
        verhuurDetailsBox.getChildren().add(dBox);
    }

    private void setProductDetailsBox() {
        productDetailsBox.getChildren().clear();
        DetailsBox dBox = new DetailsBox(product.getDetails());
        dBox.setAlignment(Pos.CENTER);
        productDetailsBox.getChildren().add(dBox);
    }

    private void setVerhuurBox() {
        verzekerCheckBox.setSelected(false);
        setHuurprijs(huurprijsLabel, false);
        voornaamField.clear();
        achternaamField.clear();
        verhuurButton.setDisable(true);
    }

    private void setHuurprijs(Label label, boolean isVerzekerd) {
        label.setText(String.format(
                "Huurprijs: €%.2f per dag",
                product.berekenHuur(1, isVerzekerd)));
    }

    private void showRetour() {
        verhuurBox.setVisible(false);
        retourButtonBox.setVisible(true);
    }

    private void showVerhuur() {
        verhuurBox.setVisible(true);
        retourButtonBox.setVisible(false);
    }

    @FXML
    void retourBtnClick(ActionEvent event) {
        product.retour();
    }

    @FXML
    void verhuurBtnClick(ActionEvent event) {
        Klant klant = new Klant(voornaamField.getText().trim(), achternaamField.getText().trim());
        product.verhuur(klant, medewerker, verzekerCheckBox.isSelected());
    }

    @Override
    public void update() {
        setBoxes();
        if (product.isOpVoorraad()) showVerhuur();
        else showRetour();
    }

    public void checkIfValidVerhuur() {
        int voornaamLength = voornaamField.getText().trim().length();
        int achternaamLength = achternaamField.getText().trim().length();

        verhuurButton.setDisable(!(voornaamLength>0&&achternaamLength>0));
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

    private void initialize() {
        product.attach(this);
        voornaamField.textProperty().addListener((observableValue, s, t1) -> checkIfValidVerhuur());
        achternaamField.textProperty().addListener((observableValue, s, t1) -> checkIfValidVerhuur());
        verzekerCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> setHuurprijs(huurprijsLabel, verzekerCheckBox.isSelected()));
        update();
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.OVERZICHT_VIEW_PATH, SceneController.OVERZICHT_VIEW_TITLE, currentStage, medewerker);
    }
}
