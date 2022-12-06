package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class Option_typeTDG extends DatabaseGateway{
    private final String CREATE = "Insert into Option_type(Item_ID, Name) Values(?, ?)";
    private final String SELECT = "Select * from Option_type where Option_type_ID = ?";
    private final String UPDATE = "Update Option_type set Item_ID = ?, Name = ?, Price = ? where Option_type_ID = ?";
    private final String DELETE = "Delete from Option_type where Option_type_ID = ?";

    public Option_typeTDG() {
        super("jdbc:sqlite:.//Project_DB.db");
    }

    public void create(int item_id, String name){
        executeQuery(CREATE, item_id, name);
    }
    public ResultSet find(int id){
        return executeQuery(SELECT, id);
    }
    public void update(int id, int item_id, double price, String name){
        executeQuery(UPDATE, item_id, name, price, id);
    }
    public void delete(int id){
        executeQuery(DELETE, id);
    }

    public ResultSet findByItemID(int id){
        return executeQuery("Select * from Option_type where Item_ID = ?", id);
    }



}
