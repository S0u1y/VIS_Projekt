package com.example.vis_projekt;

import com.example.vis_projekt.Data_Access.ItemTDG;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import com.example.vis_projekt.Data_Representantives.Option_type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ItemPageController implements AppController{
    @FXML
    private Label itemName;
    @FXML
    private Label starsAVG;
    @FXML
    private Label priceLabel;
    @FXML
    private Text descriptionLabel;
    @FXML
    private VBox sideBox;

    private Item item;

    private double currentPrice = 0;

    @Override
    public void startAppInternal(Object object) {
        if(object instanceof Item item){
            this.item = item;
            if(item.getPrice() == 0 || item.getDescription() == null){
                try(ItemTDG gateway = new ItemTDG()){
                    ResultSet rs = gateway.findPriceAndDescription(item.getId());
                    if(rs != null){
                        if(rs.next()){
                            item.setDescription(rs.getString("Description"));
                            item.setPrice(rs.getDouble("Price"));
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            itemName.setText(item.getName());
            priceLabel.setText("Price: "+item.getPrice());
            descriptionLabel.setText(item.getDescription());

            if(item.getOptions() == null || item.getOptions().isEmpty()){
                item.loadOptionTypes();
                item.loadOptions();
            }
            for(Option_type type : item.getOptions()){
                ComboBox<Option> box = new ComboBox<>();
                box.getItems().add(new Option());
                box.setPromptText(type.getDescription());

                for(Option option : type.getOptions()){
                    box.getItems().add(option);
                }

                box.setOnAction(event -> {

                    for(Node node : sideBox.getChildren()){
                        if(node instanceof ComboBox<?> check){
                            if(check.getValue() == null && check.getId() != null){
                                currentPrice -= Double.parseDouble(check.getId());
                            }else{
                                if(check.getId() != null && check == box){
                                    currentPrice -= Double.parseDouble(box.getId());
                                }
                            }
                        }
                    }
                    currentPrice += box.getValue().getPrice();
                    box.setId(""+box.getValue().getPrice());
                    priceLabel.setText("Price: " + (item.getPrice() + currentPrice));
                });

                sideBox.getChildren().add(2,box);
            }
        }




    }

    @Override
    public void startApp() {

    }

    @FXML
    private void onIndexButton(){
        MainClass.onIndexButton(itemName);
    }

    @FXML
    private void onPurchaseButton(){
        Item purchased = new Item(item.getItem_id(), item.getUser_id(), item.getName(), item.getPrice(), item.getDescription());
        for(Node node : sideBox.getChildren()){
            if(node instanceof ComboBox<?> box){
                if(box.getValue() != null && box.getId() != null){
                    Option option = (Option)box.getValue();
                    Option_type type = new Option_type(option.option_type_id(), item.getId(), box.getPromptText());
                    type.addOption(option);
                    purchased.getOptions().add(type);
                }
            }
        }
        if(MainClass.cart == null) MainClass.cart = new Cart();
        MainClass.cart.addItem(purchased);
    }

    @FXML
    private void onCartButton(){
        MainClass.onCartButton(itemName);
    }

    @FXML
    private void onAccountClicked(){
        if(MainClass.user == null){
            SceneSwapperHandler.swapScenes(itemName.getScene(), getClass().getResource("login-view.fxml"), "Login");
        }else{

        }
    }

}
