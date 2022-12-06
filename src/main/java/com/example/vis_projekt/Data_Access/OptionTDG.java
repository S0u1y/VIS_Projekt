package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class OptionTDG extends TableDataGateway{
    public OptionTDG() {
        CREATE = "Insert into Option(Option_type_ID, Price, Description) Values(%d, %f,'%s')";
        SELECT = "Select * from Option where Option_id = %d";
        UPDATE = "Update Option set option_type_id = %d, Price = %f, Description = '%s'";
        DELETE = "Delete from Option where Option_ID = %d";
    }
    public void create(int option_type_id, double price, String description){
        executeQuery(String.format(CREATE, option_type_id, price, description));
    }

    public ResultSet find(int id){
        return executeQuery(String.format(SELECT, id));
    }

    public void update(int id, int item_id, String name){
        executeQuery(String.format(UPDATE, item_id, name, id));
    }
    public void delete(int id){
        executeQuery(String.format(DELETE, id));
    }

}
