package com.bruijs.thomas.rentathingopt3.controller;

import com.bruijs.thomas.rentathingopt3.model.Medewerker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public static final String LOGIN_VIEW = "/com/bruijs/thomas/rentathingopt3/view/LoginView.fxml";
    public static final String MENU_VIEW = "/com/bruijs/thomas/rentathingopt3/view/MenuView.fxml";
    public static void showScene(String scenePath, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(scenePath));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void showMenuScene(Stage stage, Medewerker medewerker) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(MENU_VIEW));

        Scene scene = new Scene(fxmlLoader.load());
        MenuController menuController = fxmlLoader.getController();
        menuController.setMedewerker(medewerker);

        stage.setScene(scene);
        stage.setTitle("Menu: "+medewerker.getGebruikersnaam());
        stage.show();
    }
}
