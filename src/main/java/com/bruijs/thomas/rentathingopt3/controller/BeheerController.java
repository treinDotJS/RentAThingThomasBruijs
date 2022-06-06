package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.factory.ProductFactory;
import com.bruijs.thomas.rentathingopt3.model.factory.UnlabeledProductFactory;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BeheerController implements SetMedewerker {
    private final String[] PRODUCT_TYPES = new String[]{"Boormachine", "Personenauto", "Vrachtauto"};
    private String previousSelectedString = null;
    public Medewerker medewerker;

    @FXML
    private ListView<String> productListView;

    @FXML
    private Button toevoegenBtn;

    @FXML
    void onToevoegenBtnClick(ActionEvent event) throws IOException {
        showToevoegVenster();
    }

    private void showToevoegVenster() throws IOException {
        String productType = productListView.getSelectionModel().getSelectedItem();
        ProductFactory productFactory = new UnlabeledProductFactory();
        Product product = productFactory.createProduct(productType);
        Stage stage = (Stage) productListView.getScene().getWindow();
        SceneController.showScene(SceneController.TOEVOEG_VIEW_PATH, SceneController.TOEVOEG_VIEW_TITLE, stage, medewerker, product);
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.MENU_VIEW_PATH, SceneController.MENU_VIEW_TITLE, currentStage, medewerker);
    }

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
        initialize();
    }

    private void initialize() {
        toevoegenBtn.setDisable(true);
        productListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, s, t1) -> toevoegenBtn.setDisable(t1 == null)
        );
        productListView.setOnMouseClicked(mouseEvent -> setDoubleClick());
        productListView.setItems(FXCollections.observableArrayList(PRODUCT_TYPES));
    }

    private void setDoubleClick() {
        String newSelectedString = productListView.getSelectionModel().getSelectedItem();
        if (Objects.equals(previousSelectedString, newSelectedString)) {
            try {
                showToevoegVenster();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else previousSelectedString = newSelectedString;
    }
}
