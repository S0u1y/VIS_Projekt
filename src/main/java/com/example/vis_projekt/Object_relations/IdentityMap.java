package com.example.vis_projekt.Object_relations;

import com.example.vis_projekt.Data_Representantives.Representantive;

import java.util.ArrayList;

public class IdentityMap<T extends Representantive> {
    private ArrayList<T> map = new ArrayList<T>();

    public void add(T object){
        map.add(object);
    }

    public T get(int id){
        for(T object : map){
            if(object.getId() == id){
                return object;
            }
        }
        return null;
    }

    public int size(){return map.size();}

}
