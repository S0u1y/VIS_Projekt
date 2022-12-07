package com.example.vis_projekt.Object_relations;

import com.example.vis_projekt.Data_Access.PaymentTDG;
import com.example.vis_projekt.Data_Representantives.Payment;

import java.util.ArrayList;

public class PaymentUOW {

    private ArrayList<Payment> New = new ArrayList<>();
    private ArrayList<Payment> Dirty = new ArrayList<>();
    private ArrayList<Payment> Delete = new ArrayList<>();

    public void registerNew(Payment item){
        if(item.getPayment_id() <= 0 && isInAny(item) == 0){
            New.add(item);
        }
    }
    public void registerDirty(Payment item){
        if(item.getPayment_id() <= 0 && isInAny(item) != 3){
            Dirty.add(item);
        }
    }
    public void registerDelete(Payment item){
        if(!New.remove(item)){
            Dirty.remove(item);
            if(item.getPayment_id() <= 0 && !(isInAny(item) == 3)){
                Delete.add(item);
            }
        }

    }
    public void commit(){

        try(PaymentTDG gateway = new PaymentTDG()){
            for (Payment item: New) {
                gateway.create(item.getUser_id(),item.getItem_id(),item.getPrice());
            }
            for(Payment item : Dirty){
                gateway.update(item.getUser_id(), item.getItem_id(), item.getPrice(),item.getDate(),item.getPayment_id());
            }
            for(Payment item : Delete){
                gateway.delete(item.getPayment_id());
            }
        }
    }

    private int isInAny(Payment item){
        if(New.contains(item)){
            return 1;
        } else if (Dirty.contains(item)) {
            return 2;
        } else if (Delete.contains(item)) {
            return 3;
        }
        return 0;
    }




}
