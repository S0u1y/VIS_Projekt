package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Object_relations.IdentityMap;

public class MainClass {
    public static User user = null;
    private static IdentityMap<Item> items = new IdentityMap<>();
    public MainClass(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static IdentityMap<Item> getItems() {
        return items;
    }
}
