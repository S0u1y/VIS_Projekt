package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class OptionTDG extends TableDataGateway{
    public OptionTDG() {
        CREATE = "Insert into Option(Option_type_ID, Price, Description) Values(?, ?, ?)";
        SELECT = "Select * from Option where Option_id = ?";
        UPDATE = "Update Option set option_type_id = ?, Price = ?, Description = ?";
        DELETE = "Delete from Option where Option_ID = ?";
    }
    public void create(int option_type_id, double price, String description){
        executeQuery(CREATE, option_type_id, price, description);
    }

    public ResultSet find(int id){
        return executeQuery(SELECT, id);
    }

    public void update(int id, int item_id, String name){
        executeQuery(UPDATE, item_id, name, id);
    }
    public void delete(int id){
        executeQuery(DELETE, id);
    }

    public ResultSet findByOptionTypeID(int id){
        return executeQuery("Select * from Option where Option_type_ID = ?", id);
    }

}
