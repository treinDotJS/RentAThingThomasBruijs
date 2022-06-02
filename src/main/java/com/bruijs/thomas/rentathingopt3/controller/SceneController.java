package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
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

    public static void showScene(String scenePath, String title, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(scenePath));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void showScene(String scenePath, String title, Stage stage, Medewerker medewerker) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(scenePath));

        Scene scene = new Scene(fxmlLoader.load());
        SetMedewerker controller = fxmlLoader.getController();
        controller.setMedewerker(medewerker);

        stage.setTitle(String.format(title, medewerker.getGebruikersnaam()));
        stage.setScene(scene);
        stage.show();
    }
}
