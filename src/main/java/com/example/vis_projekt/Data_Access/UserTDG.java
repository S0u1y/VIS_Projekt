package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class UserTDG extends TableDataGateway{

    private final String FIND_USER_BY_ID = "Select * from User where User_ID = %d";
    private final String CREATE_USER = "INSERT into User(Address_ID, Store_ID, Name, Surname, Email, Password, Permissions) values(%d, %d, '%s', '%s', '%s', '%s', 0)";
    private final String CREATE_STAFF = "INSERT into User(Address_ID, Store_ID, Name, Surname, Email, Password, Permissions) values(%d, %d, '%s', '%s', '%s', '%s', 1)";
    private final String CREATE_MANAGER = "INSERT into User(Address_ID, Store_ID, Name, Surname, Email, Password, Permissions) values(%d, %d, '%s', '%s', '%s', '%s', 2)";
    private final String UPDATE_USER = "UPDATE User SET Address_ID = %d, Store_ID = %d, name = '%s', surname = '%s', email = '%s', password = '%s', permissons = %d where User_ID = %d";
    private final String DELETE_USER = "delete from User where User_ID = %d";
    private final String FIND_USER_BY_EMAIL = "Select * from User where Email = '%s'";

    public UserTDG(){
        super();
    }

    public void createUser(int address, int store, String name, String surname, String email, String password){
        executeQuery(String.format(CREATE_USER, address, store, name, surname, email, password));
    }
    public void createStaff(int address, int store, String name, String surname, String email, String password){
        executeQuery(String.format(CREATE_STAFF, address, store, name, surname, email, password));
    }
    public void createManager(int address, int store, String name, String surname, String email, String password){
        executeQuery(String.format(CREATE_MANAGER, address, store, name, surname, email, password));
    }
    public ResultSet find(int id){
        return executeQuery(String.format(FIND_USER_BY_ID, id));
    }
    public ResultSet findByEmail(String email){
        return executeQuery(String.format(FIND_USER_BY_EMAIL, email));
    }
    public void update(int id, int address, int store, String name, String surname, String email, String password, int permissions){
        executeQuery(String.format(UPDATE_USER, address, store, name, surname, email, password, permissions, id));
    }

    public void delete(int id){
        executeQuery(String.format(DELETE_USER, id));
    }

}
