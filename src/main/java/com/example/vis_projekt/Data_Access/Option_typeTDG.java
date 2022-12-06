package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class Option_typeTDG extends DatabaseGateway{
    private final String CREATE = "Insert into Option_type(Item_ID, Name) Values(%d, '%s')";
    private final String SELECT = "Select * from Option_type where Option_type_ID = %d";
    private final String UPDATE = "Update Option_type set Item_ID = %d, Name = '%s' where Option_type_ID = %d";
    private final String DELETE = "Delete from Option_type where Option_type_ID = %d";

    public Option_typeTDG() {
        super("jdbc:sqlite:.//Project_DB.db");
    }

    public void create(int item_id, String name){
        executeQuery(String.format(CREATE, item_id, name));
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
