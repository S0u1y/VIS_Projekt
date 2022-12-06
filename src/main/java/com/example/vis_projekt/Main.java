package com.example.vis_projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private IndexController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("index-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Index");
        stage.setScene(scene);
        stage.show();

        controller = fxmlLoader.getController();
        controller.startApp();

//        try(OptionTDG gateway = new OptionTDG()){
//            gateway.create(1,75,"30cm");//75 = 75,000 !!!
//        }

    }

    public static void main(String[] args) {

        launch();
    }
}