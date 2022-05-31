package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.data.ProductMagazijn;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class OverzichtController implements SetMedewerker{
    private Medewerker medewerker;
    @FXML
    private ListView<Product> productListView;
    @FXML
    private Button detailsBtn;

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
        initialize();
    }

    private void initialize() {
        productListView.setItems(FXCollections.observableArrayList(ProductMagazijn.producten));
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.MENU_VIEW_PATH, SceneController.OVERZICHT_VIEW_TITLE, currentStage, medewerker);
    }

    @FXML
    void showDetails(ActionEvent event) {
        Product product = productListView.getSelectionModel().getSelectedItem();
        System.out.println(product);
    }
}
