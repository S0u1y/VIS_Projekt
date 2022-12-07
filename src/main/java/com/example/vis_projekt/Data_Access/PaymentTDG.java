package com.example.vis_projekt.Data_Access;


import com.example.vis_projekt.DateMethods;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentTDG extends TableDataGateway{

    private final String FIND_BY_USER_ID = "Select * from Payment where User_ID = ?";
    private final String FIND_BY_ITEM_ID = "Select * from Payment where Item_ID = ?";
    private final String FIND_BY_USER_AND_ITEM = "Select * from Payment where User_ID = ? and Item_ID = ?";

    public PaymentTDG() {
        CREATE = "Insert into Payment(User_ID, Item_ID, Price, Date) Values(?,?,?,?)";
        FIND_BY_ID = "Select * from Payment where Payment_ID = ?";
        UPDATE = "Update Payment set User_ID = ?, Item_ID = ?, Price = ?, Date = ?, where payment_ID = ?";
        DELETE = "Delete from Payment where Payment_ID = ?";
    }

    public void create(int user_id, int item_id, double price){
        executeQuery(CREATE, user_id, item_id, price, DateMethods.getDate());
    }

    public ResultSet find(int id){
        return executeQuery(FIND_BY_ID, id);
    }

    public void update(int user_id, int item_id, double price, String date, int id){
        executeQuery(UPDATE, user_id, item_id, price, date, id);
    }

    public void delete(int id){
        executeQuery(DELETE, id);
    }

    public ResultSet findByItemID(int item_id){
        return executeQuery(FIND_BY_ITEM_ID, item_id);
    }

    public ResultSet findByUserID(int user_id){
        return executeQuery(FIND_BY_USER_ID, user_id);
    }

    public ResultSet findByUserAndItem(int user_id, int item_id){
        return executeQuery(FIND_BY_USER_AND_ITEM, user_id, item_id);
    }



}
