package com.example.vis_projekt.Data_Representantives;

import java.util.ArrayList;

public class Option_type {
    private int category_id = -1;
    private int item_id = -1;
    private String description;
    private ArrayList<Option> options = new ArrayList<>();

    public Option_type(int category_id, int item_id) {
        this.category_id = category_id;
        this.item_id = item_id;
    }

    public Option_type(int category_id, int item_id, String description) {
        this.category_id = category_id;
        this.item_id = item_id;
        this.description = description;
    }

    public void addOption(Option option){
        options.add(option);
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
