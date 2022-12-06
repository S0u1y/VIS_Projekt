package com.example.vis_projekt;

import com.example.vis_projekt.Data_Access.ItemTDG;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemPageController implements AppController{
    @FXML
    private Label itemName;
    @FXML
    private Label priceLabel;
    @FXML
    private Text descriptionLabel;
    @FXML
    private VBox sideBox;

    private Item item;

    @Override
    public void startAppInternal(Object object) {
        if(object instanceof Item item){
            this.item = item;
            if(item.getPrice() == 0 || item.getDescription() == null){
                try(ItemTDG gateway = new ItemTDG()){
                    ResultSet rs = gateway.findPriceAndDescription(item.getId());
                    if(rs.next()){
                        item.setDescription(rs.getString("Description"));
                        item.setPrice(rs.getDouble("Price"));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            itemName.setText(item.getName());
            priceLabel.setText("Price: "+item.getPrice());
            descriptionLabel.setText(item.getDescription());
        }
        ComboBox<Option> box = new ComboBox<>();
        box.getItems().add(new Option(-1,-1,"much cool  25", 25));
        sideBox.getChildren().add(2,box);

    }

    @Override
    public void startApp() {

    }
}
