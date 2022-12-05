package com.example.vis_projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SceneSwapperHandler {

    public static void swapScenes(ActionEvent event, URL url){

        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            return;

        }

    }
    public static void swapScenes(Scene inScene, URL url){

        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage)inScene.getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            return;

        }

    }

    public static void swapScenes(Scene inScene, URL url, String name){

        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage)inScene.getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(name);
            stage.show();
        } catch (IOException e) {
            return;

        }

    }

    public static void setStageName(Stage stage,String name){
        stage.setTitle(name);
    }
    public static void setStageName(Scene scene,String name){
        Stage stage = (Stage)scene.getWindow();
        stage.setTitle(name);
    }
}
