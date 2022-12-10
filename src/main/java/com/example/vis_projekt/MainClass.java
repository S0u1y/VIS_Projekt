package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.Item;
import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Object_relations.IdentityMap;
import javafx.scene.Node;

public class MainClass {
    public static User user = null;
    private static IdentityMap<Item> items = new IdentityMap<>();

    public static Cart cart = null;

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

    public static void onIndexButton(Node node){
        SceneSwapperHandler.swapScenes(node.getScene(), MainClass.class.getResource("index-view.fxml"), "Index");
    }

    public static void onCartButton(Node node){
        SceneSwapperHandler.swapScenes(node.getScene(), MainClass.class.getResource("cart-view.fxml"), "Cart");
    }

}
