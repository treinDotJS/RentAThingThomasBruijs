package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.data.ProductMagazijn;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ToevoegController implements SetMedewerker, SetProduct{
    private Medewerker medewerker;
    private Product product;
    @FXML
    private TextField detail1Field, detail2Field;
    @FXML
    private Label detail1Label, detail2Label, productTypeLabel;
    @FXML
    private Button toevoegenBtn;

    @FXML
    void terugButtonClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.BEHEER_VIEW_PATH, SceneController.BEHEER_VIEW_TITLE, currentStage, medewerker);
    }

    @FXML
    void onToevoegenBtnClick(ActionEvent event) {
        String detail1 = detail1Field.getText();
        String detail2 = detail2Field.getText();
        try {
            product.setDetail1(detail1);
            product.setDetail2(detail2);
            ProductMagazijn.huidigMagazijn.addProduct(product);
            Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
            SceneController.showScene(SceneController.BEHEER_VIEW_PATH, SceneController.BEHEER_VIEW_TITLE, currentStage, medewerker);
        }catch (Exception e) {
            System.out.println("Er is iets misgegaan");
        }
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
        toevoegenBtn.setDisable(true);
        detail1Field.textProperty().addListener((observableValue, s, t1) -> toevoegenBtn.setDisable(!checkIfValidInput()));
        detail2Field.textProperty().addListener((observableValue, s, t1) -> toevoegenBtn.setDisable(!checkIfValidInput()));
        updateControls();
    }

    private boolean checkIfValidInput() {
        String detail1Value = detail1Field.getText().trim();
        String detail2Value = detail2Field.getText().trim();

        if (!correctStringLength(detail1Value, detail2Value)) return false;
        return correctValueType(detail1Value, detail2Value);
    }

    private boolean correctValueType(String detail1Value, String detail2Value) {
        try {
            product.setDetail1(detail1Value);
            product.setDetail2(detail2Value);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean correctStringLength(String detail1Value, String detail2Value) {
        int detail1Length = detail1Value.length();
        int detail2Length = detail2Value.length();
        return detail1Length > 0 && detail2Length > 0;
    }

    private void updateControls() {
        productTypeLabel.setText(product.getClass().getSimpleName());
        detail1Label.setText(product.getDetail1Name());
        detail2Label.setText(product.getDetail2Name());
    }
}
