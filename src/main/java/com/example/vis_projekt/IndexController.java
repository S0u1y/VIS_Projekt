package com.example.vis_projekt;

import com.example.vis_projekt.Data_Access.ItemTDG;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Object_relations.IdentityMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexController implements AppController{

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
    @FXML
    private Button templateButton0;

    private IdentityMap<Item> items = MainClass.getItems();

    private int currentPage = 1;

    @Override
    public void startAppInternal(Object object) {

    }

    public void startApp() {
        //load n amount of items and shove them into itemsGrid

        try(ItemTDG gateway = new ItemTDG()){
            ResultSet rs = gateway.getAllNames();
            while(rs.next()){
                items.add(new Item(rs.getInt("Item_ID"),rs.getString("Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < itemsGrid.getRowCount(); i++){
            for(int j = 0; j < itemsGrid.getColumnCount(); j++){
                int index = itemsGrid.getColumnCount() * i + j;
                Item found = items.get(currentPage * (index+1));
                if(found != null){
                    Button btn = (Button)itemsGrid.getChildren().get(index);
                    btn.setText(found.getName());
                    btn.setId(""+found.getId());
                    btn.setVisible(true);
                }
            }
        }

    }





    @FXML
    private void onAccountClicked(){
        if(MainClass.user == null){
            SceneSwapperHandler.swapScenes(mainPane.getScene(), getClass().getResource("login-view.fxml"), "Login");
        }else{

        }
    }

    @FXML
    private void onItemSelected(ActionEvent e){
        int id = Integer.parseInt(((Button)(e.getTarget())).getId());
        Item selected = items.get(id);
        SceneSwapperHandler.swapScenes(mainPane.getScene(), getClass().getResource("ItemPage-view.fxml"), selected.getName(), selected);
    }

    @FXML
    private void onCartButton(){
        MainClass.onCartButton(mainPane);
    }

}