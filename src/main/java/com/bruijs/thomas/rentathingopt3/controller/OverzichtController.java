package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OverzichtController implements SetMedewerker{
    private Medewerker medewerker;
    @FXML
    private ListView<Product> productListView;


    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }
}
