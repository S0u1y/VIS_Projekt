package com.example.vis_projekt;

import com.example.vis_projekt.Data_Access.PaymentTDG;
import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.Option;
import com.example.vis_projekt.Data_Representantives.Option_type;

import java.util.ArrayList;

public class Cart {

    private double totalPrice;
    private double coupon = 1;
    private ArrayList<Item> items = new ArrayList<>();

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
        return output * coupon;
    }

    public void addCoupon(double amount){//amount in %
        coupon -= amount/100;
    }

    public void checkout(){

        for(Item item : items){

            try(PaymentTDG PGateway = new PaymentTDG()){

                double finalItemPrice = item.getPrice();
                for(Option_type type : item.getOptions()){
                    for(Option option : type.getOptions()){
                        finalItemPrice += option.getPrice();
                    }
                }

                PGateway.create(MainClass.user.getUser_id(), item.getItem_id(), finalItemPrice * coupon);

            }

        }

    }


}
