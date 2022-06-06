package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.data.ProductMagazijn;
import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.Observer;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class OverzichtController implements Observer, SetMedewerker{
    private Medewerker medewerker;
    private Product previousSelectedProduct = null;
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
        detailsBtn.setDisable(true);
        productListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, product, t1) -> detailsBtn.setDisable(t1 == null)
        );

        productListView.setOnMouseClicked(mouseEvent -> setDoubleClick());
        ProductMagazijn.huidigMagazijn.attach(this);
        update();
    }

    private void setDoubleClick() {
        Product newSelectedProduct = productListView.getSelectionModel().getSelectedItem();
        if (previousSelectedProduct == newSelectedProduct) {
            try {
                showDetails();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else previousSelectedProduct = newSelectedProduct;
    }

    @FXML
    void previousScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Control)event.getSource()).getScene().getWindow();
        SceneController.showScene(SceneController.MENU_VIEW_PATH, SceneController.OVERZICHT_VIEW_TITLE, currentStage, medewerker);
    }

    @FXML
    void onDetailBtnClick(ActionEvent event) throws IOException {
        showDetails();
    }

    private void showDetails() throws IOException {
        Product product = productListView.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) productListView.getScene().getWindow();
        SceneController.showScene(SceneController.DETAIL_VIEW_PATH, SceneController.DETAIL_VIEW_TITLE, stage, medewerker, product);
    }

    @Override
    public void update() {
        productListView.setItems(FXCollections.observableArrayList(ProductMagazijn.huidigMagazijn.getProducten()));
    }
}
