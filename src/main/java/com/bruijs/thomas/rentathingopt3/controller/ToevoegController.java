package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.data.ProductMagazijn;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import com.bruijs.thomas.rentathingopt3.model.product.detail.Detail;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ToevoegController implements SetMedewerker, SetProduct{
    private Medewerker medewerker;
    private Product product;
    private boolean[] correctFields;
    @FXML
    private VBox detailsBox;
    @FXML
    private Label productTypeLabel;
    @FXML
    private Button toevoegenBtn;

    @FXML
    void terugButtonClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.BEHEER_VIEW_PATH, SceneController.BEHEER_VIEW_TITLE, currentStage, medewerker);
    }

    @FXML
    void onToevoegenBtnClick(ActionEvent event) {
        try {
            bindValues();
            ProductMagazijn.huidigMagazijn.addProduct(product);
            Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
            SceneController.showScene(SceneController.BEHEER_VIEW_PATH, SceneController.BEHEER_VIEW_TITLE, currentStage, medewerker);
        }catch (NumberFormatException ignored) {
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean bindValues() {
        String[] detailValues = getDetailValues();
        for (int i = 0; i < detailValues.length; i++) {
            String value = detailValues[i];
            if (!product.getDetail(i).setValueWithString(value)) return false;
        }
        return true;
    }

    private String[] getDetailValues() {
        String[] detailValues = new String[detailsBox.getChildren().size()];
        ObservableList<Node> children = detailsBox.getChildren();
        for (int i = 0; i < children.size(); i++) {
            VBox entryVBox = (VBox) children.get(i);
            TextField valueField = (TextField) entryVBox.getChildren().get(1);
            detailValues[i] = valueField.getText().trim();
        }
        return detailValues;
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
        updateControls();
    }

    private void updateControls() {
        detailsBox.getChildren().clear();
        toevoegenBtn.setDisable(true);
        addDetailFields(detailsBox);
        productTypeLabel.setText(product.getClass().getSimpleName());
    }

    private void addDetailFields(VBox detailsBox) {
        ArrayList<Detail> details = product.getDetails();
        correctFields = new boolean[details.size()];
        for (int i = 0; i < details.size(); i++) {
            correctFields[i] = false;
            Detail detail = details.get(i);
            VBox entry = createDetailField(i, detail);
            detailsBox.getChildren().add(entry);
        }
    }

    private VBox createDetailField(final int index, Detail detail) {
        Label label = new Label(detail.getName());
        TextField field = new TextField();
        field.textProperty().addListener((observableValue, s, t1) -> {
            correctFields[index] = t1.trim().length() > 0;
            toevoegenBtn.setDisable(!checkCorrectInput());
        });
        return new VBox(label, field);
    }

    private boolean checkCorrectInput() {
        if(checkFields())
            return bindValues();
        return false;
    }

    private boolean checkFields() {
        for (boolean bool : correctFields)
            if (!bool) return false;
        return true;
    }
}
