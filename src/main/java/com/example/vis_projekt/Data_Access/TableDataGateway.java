package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class TableDataGateway extends DatabaseGateway{

    protected String CREATE;
    protected String SELECT;
    protected String UPDATE;
    protected String DELETE;

    public TableDataGateway() {
        super("jdbc:sqlite:.//Project_DB.db");
    }



}
