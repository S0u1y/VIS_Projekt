package com.example.vis_projekt.Domain_Logic;

import com.example.vis_projekt.Data_Access.UserTDG;
import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Encoding;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTM {

    public User Register(int address, int store, String name, String surname, String email, String password){
        if(isEmpty(name)){
            System.out.println("Name cannot be blank!");
            return null;
        }
        if(isEmpty(email) || !email.contains("@")){
            System.out.println("Email cannot be blank!");
            return null;
        }
        if(isEmpty(password)){
            System.out.println("Password cannot be blank!");
            return null;
        }

        User output = null;
        try(UserTDG gateway = new UserTDG()){
            if(gateway.findByEmail(email).next()){
                System.out.println("User already existus!");
            }else{
                gateway.createUser(address, store, name, surname, email, Encoding.Hash(password));
                output = new User(name,surname,email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
    public User Login(String email, String pass){
        User output=null;
        if(isEmpty(email) || !email.contains("@")){
            System.out.println("Email cannot be blank!");
            return null;
        }
        if(isEmpty(pass)){
            System.out.println("Password cannot be blank!");
            return null;
        }

        String hashPass = Encoding.Hash(pass);
        String cmpPass = null;
        try(UserTDG gateway = new UserTDG()){
            ResultSet rs = gateway.findByEmail(email);
            if(rs != null && rs.next()){
                cmpPass = rs.getString("Password");
                if(cmpPass.equals(hashPass)){
                    output = new User(rs.getString("Name"),rs.getString("Surname"),rs.getString("Email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    private boolean isEmpty(String string){
        if(string.isEmpty() || string.isBlank()){
            return true;
        }
        return false;
    }

}
