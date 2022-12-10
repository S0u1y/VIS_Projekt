package com.example.vis_projekt.Domain_Logic;

import com.example.vis_projekt.Cart;
import com.example.vis_projekt.Data_Access.OptionTDG;
import com.example.vis_projekt.Data_Access.Option_typeTDG;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import com.example.vis_projekt.Data_Representantives.Option_type;
import com.example.vis_projekt.MainClass;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void loadItemOptions(Item item){

        try(Option_typeTDG gateway = new Option_typeTDG()){
            ResultSet rs = gateway.findByItemID(item.getItem_id());
            if(rs != null){
                while(rs.next()){
                    item.getOptions().add(new Option_type(rs.getInt("Option_type_ID"), item.getItem_id(), rs.getString("Name")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(OptionTDG gateway = new OptionTDG()){

            for(Option_type type : item.getOptions()){
                ResultSet rs = gateway.findByOptionTypeID(type.getCategory_id());
                while(rs.next()){
                    type.addOption(new Option(rs.getInt("Option_ID"), type.getCategory_id(), rs.getString("Description"), rs.getDouble("Price")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for(Option_type type : item.getOptions()){
            type.getOptions().add(0, new Option());
        }

    }


}
