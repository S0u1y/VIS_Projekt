package com.example.vis_projekt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethods {

    public static String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
