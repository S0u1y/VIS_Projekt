package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class ItemTDG extends TableDataGateway{

    private final String FIND_PRICE = "Select Price from Item where Item_ID = ?";
    private final String FIND_DESCRIPTION = "Select Description from Item where Item_ID = ?";
    private final String FIND_P_D = "Select Price, Description from Item where Item_ID = ?";

    public ItemTDG() {
        super();
        CREATE = "Insert into Item(User_ID, Name, Price, Description) values(?, ?, ?, ?)";
        FIND_BY_ID = "Select * from Item where Item_ID = ?";
        UPDATE = "Update Item set User_ID = ?, Name = ?, Price = ?, Description = ? where Item_ID = ?";
        DELETE = "Delete from Item where Item_ID = ?";
    }


    public void create(int user_id, String name, double price, String description) {
        executeQuery(CREATE, user_id, name, price, description);
    }

    public ResultSet find(int id) {
        return executeQuery(FIND_BY_ID, id);
    }

    public void update(int item_id, int user_id, String name, double price, String description) {
        executeQuery(UPDATE, user_id, name, price, description, item_id);
    }

    public void delete(int id) {
        executeQuery(DELETE, id);
    }

    public ResultSet getAll(){
        return executeQuery("Select * from Item");
    }
    public ResultSet getAllNames(){
        return executeQuery("Select Item_ID, Name from Item");
    }

    public ResultSet findPrice(int id){
        return executeQuery(FIND_PRICE, id);
    }
    public ResultSet findDescription(int id){
        return executeQuery(FIND_DESCRIPTION, id);
    }
    public ResultSet findPriceAndDescription(int id){
        return executeQuery(FIND_P_D, id);
    }
}
