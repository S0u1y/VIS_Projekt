package com.example.vis_projekt.Data_Representantives;

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

    public void loadOptions(){

    }

}
