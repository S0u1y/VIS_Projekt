package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CartViewController implements AppController{

    @FXML
    private Pane mainPane;

    @FXML
    private GridPane itemsGrid;

    @FXML
    private Label priceLabel;

    @Override
    public void startAppInternal(Object object) {

    }

    @Override
    public void startApp() {
        if(MainClass.cart != null){
            ArrayList<Item> items = MainClass.cart.getItems();
            for(int i = 0; i < items.size(); i++){
                if(i > itemsGrid.getChildren().size()){
                    itemsGrid.addRow(i);
                }
                if(itemsGrid.getChildren().get(i) != null){
                    Label label = (Label)itemsGrid.getChildren().get(i);
                    label.setText(items.get(i).getName());
                    label.setVisible(true);
                }
            }
            //cart calculates full price
            priceLabel.setText("Price: "+ MainClass.cart.calculatePrice());
        }else {
            priceLabel.setText("No Items picked.");
        }


    }

    @FXML
    private void onIndexButton(){
        MainClass.onIndexButton(mainPane);
    }

    @FXML
    private void onAccountClicked(){

    }

}
