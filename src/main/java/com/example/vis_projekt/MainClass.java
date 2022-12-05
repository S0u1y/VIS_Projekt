package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.User;

public class MainClass {
    public static User user = null;

    public MainClass(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
