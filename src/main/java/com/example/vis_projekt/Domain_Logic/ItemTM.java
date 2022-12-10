package com.example.vis_projekt.Domain_Logic;

import com.example.vis_projekt.Cart;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import com.example.vis_projekt.Data_Representantives.Option_type;
import com.example.vis_projekt.MainClass;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.concurrent.CopyOnWriteArrayList;

public class ItemTM {

    public boolean purchaseItem(Item item, VBox sideBox){

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

        return true;
    }

    public double calculateValue(Item item,Option option){
        CopyOnWriteArrayList<Option_type> copy1 = new CopyOnWriteArrayList<>(item.getOptions());
        for(Option_type type : copy1){
            if(type.getOptions().remove(option))
                type.getOptions().add(0,option);
        }
        double output = item.getPrice();
        for(Option_type type : item.getOptions()){
            output += type.getOptions().get(0).getPrice();
        }

        return output;
    }

}
