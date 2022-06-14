package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import com.bruijs.thomas.rentathingopt3.model.ViewInfo;
import com.bruijs.thomas.rentathingopt3.model.product.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public static final ViewInfo LOGIN_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/LoginView.fxml", "Login");
    public static final ViewInfo MENU_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/MenuView.fxml", "Menu: %s");
    public static final ViewInfo OVERZICHT_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/OverzichtView.fxml", "Overzicht: %s");
    public static final ViewInfo BEHEER_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/BeheerView.fxml", "Beheer: %s");
    public static final ViewInfo TOEVOEG_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/ToevoegView.fxml", "Toevoegvenster: %s");
    public static final ViewInfo DETAIL_VIEW = new ViewInfo("/com/bruijs/thomas/rentathingopt3/view/DetailView.fxml", "Detailvenster: %s");

    public static void showScene(ViewInfo viewInfo, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(viewInfo.getPath()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(viewInfo.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    public static void showScene(ViewInfo viewInfo, Stage stage, Medewerker medewerker) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(viewInfo.getPath()));

        Scene scene = new Scene(fxmlLoader.load());
        setMedewerker(medewerker, fxmlLoader);

        stage.setTitle(String.format(viewInfo.getTitle(), medewerker.getGebruikersnaam()));
        stage.setScene(scene);
        stage.show();
    }

    public static void showScene(ViewInfo viewInfo, Stage stage, Medewerker medewerker, Product product) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(viewInfo.getPath()));

        Scene scene = new Scene(fxmlLoader.load());
        setMedewerker(medewerker, fxmlLoader);
        setProduct(product, fxmlLoader);

        stage.setTitle(String.format(viewInfo.getTitle(), medewerker.getGebruikersnaam()));
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
