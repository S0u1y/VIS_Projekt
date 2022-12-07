package com.example.vis_projekt.Data_Access;

import java.sql.ResultSet;

public class TableDataGateway extends DatabaseGateway{

    public TableDataGateway() {
        super("jdbc:sqlite:.//Project_DB.db");
    }



}
