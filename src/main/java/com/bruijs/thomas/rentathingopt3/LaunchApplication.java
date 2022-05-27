package com.bruijs.thomas.rentathingopt3;

import com.bruijs.thomas.rentathingopt3.controller.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LaunchApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneController.showScene(SceneController.LOGIN_VIEW, stage);
    }

    public static void main(String[] args) {
        launch();
    }
}