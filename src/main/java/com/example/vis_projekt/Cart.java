package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import com.example.vis_projekt.Data_Representantives.Option_type;

import java.util.ArrayList;

public class Cart {


    private double totalPrice;
    ArrayList<Item> items = new ArrayList<>();

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public double calculatePrice(){
        double output = 0;
        for(Item item : items){
            output += item.getPrice();
            for(Option_type type : item.getOptions()){
                for(Option option : type.getOptions()){
                    output += option.getPrice();
                }
            }
        }
        return output;
    }

    public void checkout(){

    }


}
