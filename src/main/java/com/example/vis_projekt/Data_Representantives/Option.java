package com.example.vis_projekt.Data_Representantives;

public class Option {
    private int option_id;
    private int option_type_id;

    private String description;
    private double price;

    public Option(int option_id, int option_type_id, String description, double price) {
        this.option_id = option_id;
        this.option_type_id = option_type_id;
        this.description = description;
        this.price = price;
    }

    public int getOption_id() {
        return option_id;
    }

    public int option_type_id() {
        return option_type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return description;
    }
}
