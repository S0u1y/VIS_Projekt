package com.example.vis_projekt.Data_Representantives;

import com.example.vis_projekt.Data_Access.OptionTDG;
import com.example.vis_projekt.Data_Access.Option_typeTDG;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Item extends Representantive{

    private int item_id;
    private int user_id;
    private String name;
    private double price;
    private String description;

    ArrayList<Option_type> options = new ArrayList<>();

    public Item() {
        item_id = -1;
        user_id = -1;
        id = item_id;
    }

    public Item(String name, double price, String description) {
        item_id = -1;
        user_id = -1;
        id = item_id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Item(int item_id, int user_id, String name, double price, String description) {
        this.item_id = item_id;
        this.user_id = user_id;
        id = item_id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Item(int item_id, String name) {
        this.item_id = item_id;
        id = item_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Option_type> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option_type> options) {
        this.options = options;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void loadOptionTypes(){
        try(Option_typeTDG gateway = new Option_typeTDG()){
            ResultSet rs = gateway.findByItemID(this.item_id);
            if(rs != null){
                while(rs.next()){
                    options.add(new Option_type(rs.getInt("Option_type_ID"), this.item_id, rs.getString("Name")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadOptions(){
        try(OptionTDG gateway = new OptionTDG()){

            for(Option_type type : options){
                ResultSet rs = gateway.findByOptionTypeID(type.getCategory_id());
                while(rs.next()){
                    type.addOption(new Option(rs.getInt("Option_ID"), type.getCategory_id(), rs.getString("Description"), rs.getDouble("Price")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
