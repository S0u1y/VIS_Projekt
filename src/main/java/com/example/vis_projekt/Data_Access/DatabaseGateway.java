package com.example.vis_projekt.Data_Access;

import java.io.Closeable;
import java.sql.*;

public class DatabaseGateway implements Closeable {

    private String URL;
    protected String tableName;
    protected String CREATE;
    protected String FIND_BY_ID;
    protected String UPDATE;
    protected String DELETE;


    public DatabaseGateway(String URL) {
        this.URL = URL;
    }

    private Connection connection = null;
    protected Connection connect(){

        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    protected ResultSet executeQuery(String sql){
        connection = connect();
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            if(e.getErrorCode() == 101){//sometimes queries don't return anything (insert, update, ..)
                return null;
            }
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void close(){
        try {
            if(!this.connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void constructStrings(){
        FIND_BY_ID = "SELECT %s from "+tableName+" where %s = ";
        CREATE = "INSERT into "+tableName+"%s";
        UPDATE = "UPDATE "+tableName+" SET %s";
        DELETE = "DELETE from "+tableName+" where %s = ";
    }

}
