package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HelloController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private HBox topPanel;
    @FXML
    private GridPane itemsGrid;
    @FXML
    private Button indexButton;
    @FXML
    private TextField searchBar;
    @FXML
    private Button accountButton;
    @FXML
    private Button cartButton;
    @FXML
    private Button previousButton, nextButton;

    public void startApp() {
        //load n amount of items and shove them into itemsGrid

    }





    @FXML
    private void onAccountClicked(){
        if(MainClass.user == null){
            SceneSwapperHandler.swapScenes(mainPane.getScene(), getClass().getResource("login-view.fxml"), "Login");
        }else{

        }
    }


}