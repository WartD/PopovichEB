package com.example.popovich;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("OperationsOverview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Лабораторная 1.8");
        OperationsOverviewController controller = fxmlLoader.getController();
        controller.getStage(stage);
        stage.getIcons().add(new Image(Objects.requireNonNull(MainApp.class.getResourceAsStream("/com/example/popovich/images/logo.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}