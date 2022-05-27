package com.bruijs.thomas.rentathingopt3.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public static final String LOGIN_VIEW = "/com/bruijs/thomas/rentathingopt3/view/LoginView.fxml";
    public static void showScene(String scenePath, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(scenePath));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
