package com.example.vis_projekt.Data_Representantives;

public class Payment {

    private int payment_id;
    private int user_id;
    private int item_id;
    private double price;
    private String date;

    public Payment(int payment_id, int user_id, int item_id, double price, String date) {
        this.payment_id = payment_id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.price = price;
        this.date = date;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
