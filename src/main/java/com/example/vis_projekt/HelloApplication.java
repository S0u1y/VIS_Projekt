package com.example.vis_projekt;

import com.example.vis_projekt.Data_Access.OptionTDG;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private HelloController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Index");
        stage.setScene(scene);
        stage.show();

        controller = fxmlLoader.getController();
        controller.startApp();

        try(OptionTDG gateway = new OptionTDG()){
            gateway.create(1,75,"30cm");
        }

    }

    public static void main(String[] args) {

        launch();
    }
}