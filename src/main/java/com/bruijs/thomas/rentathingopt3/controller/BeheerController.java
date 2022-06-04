package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.factory.ProductFactory;
import com.bruijs.thomas.rentathingopt3.model.factory.UnlabeledProductFactory;
import com.bruijs.thomas.rentathingopt3.model.product.Personenauto;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class BeheerController implements SetMedewerker {
    private final String[] PRODUCT_TYPES = new String[]{"Boormachine", "Personenauto", "Vrachtauto"};
    public Medewerker medewerker;

    @FXML
    private ListView<String> productListView;

    @FXML
    private Button toevoegenBtn;

    @FXML
    void nieuwProduct(ActionEvent event) throws IOException {
        String productType = productListView.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        ProductFactory productFactory = new UnlabeledProductFactory();
        Product product = productFactory.createProduct(productType);
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
        productListView.setItems(FXCollections.observableArrayList(PRODUCT_TYPES));
    }
}
