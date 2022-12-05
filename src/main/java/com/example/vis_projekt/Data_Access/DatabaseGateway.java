package com.example.vis_projekt.Data_Access;

import java.io.Closeable;
import java.sql.*;

public abstract class DatabaseGateway implements Closeable {

    private String URL;

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

}
