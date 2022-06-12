package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public static final String LOGIN_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/LoginView.fxml";
    public static final String LOGIN_VIEW_TITLE = "Login";
    public static final String MENU_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/MenuView.fxml";
    public static final String MENU_VIEW_TITLE = "Menu: %s";
    public static final String OVERZICHT_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/OverzichtView.fxml";
    public static final String OVERZICHT_VIEW_TITLE = "Overzicht: %s";
    public static final String BEHEER_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/BeheerView.fxml";
    public static final String BEHEER_VIEW_TITLE = "Beheer: %s";
    public static final String TOEVOEG_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/ToevoegView.fxml";
    public static final String TOEVOEG_VIEW_TITLE = "Toevoegvenster: %s";
    public static final String DETAIL_VIEW_PATH = "/com/bruijs/thomas/rentathingopt3/view/DetailView.fxml";
    public static final String DETAIL_VIEW_TITLE = "Detailvenster: %s";

    public static void showScene(String scenePath, String title, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = getFxmlLoader(scenePath);
        Scene scene = new Scene(fxmlLoader.load());
        setAndShowStage(title, stage, scene);
    }

    public static void showScene(String scenePath, String title, Stage stage, Medewerker medewerker) throws IOException {
        FXMLLoader fxmlLoader = getFxmlLoader(scenePath);

        Scene scene = new Scene(fxmlLoader.load());
        setMedewerker(medewerker, fxmlLoader);

        setAndShowStage(String.format(title, medewerker.getGebruikersnaam()), stage, scene);
    }

    public static void showScene(String scenePath, String title, Stage stage, Medewerker medewerker, Product product) throws IOException {
        FXMLLoader fxmlLoader = getFxmlLoader(scenePath);

        Scene scene = new Scene(fxmlLoader.load());
        setMedewerker(medewerker, fxmlLoader);
        setProduct(product, fxmlLoader);

        setAndShowStage(String.format(title, medewerker.getGebruikersnaam()), stage, scene);
    }

    private static FXMLLoader getFxmlLoader(String scenePath) {
        return new FXMLLoader(SceneController.class.getResource(scenePath));
    }

    private static void setAndShowStage(String title, Stage stage, Scene scene) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static void setMedewerker(Medewerker medewerker, FXMLLoader loader) {
        SetMedewerker controller = loader.getController();
        controller.setMedewerker(medewerker);
    }
    private static void setProduct(Product product, FXMLLoader loader) {
        SetProduct controller = loader.getController();
        controller.setProduct(product);
    }
}
