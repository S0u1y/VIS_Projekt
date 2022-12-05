package com.example.vis_projekt.Data_Representantives;

public class Item {

    private int item_id;
    private int user_id;
    private String name;
    private double price;
    private String description;

    public Item() {
        item_id = -1;
        user_id = -1;
    }

    public Item(String name, double price, String description) {
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
}
