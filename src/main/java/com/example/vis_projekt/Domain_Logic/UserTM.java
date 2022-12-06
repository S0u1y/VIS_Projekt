package com.example.vis_projekt.Domain_Logic;

import com.example.vis_projekt.Data_Access.UserTDG;
import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Encoding;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTM {
    private String errorMessage = "";

    public User Register(int address, int store, String name, String surname, String email, String password){
        if (!credentialsFine(name, email, password)) return null;

        User output = null;
        try(UserTDG gateway = new UserTDG()){
            if(gateway.findByEmail(email).next()){
                errorMessage = "Password cannot be blank!";
            }else{
                gateway.createUser(address, store, name, surname, email, Encoding.Hash(password));
                output = new User(name,surname,email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
    public User Register(int address, int store, String name, String surname, String email, String password, String passwordCheck){
        if (!credentialsFine(name, email, password)) return null;
        if(isEmpty(passwordCheck)){
            errorMessage = "Password check cannot be blank!";
            return null;
        }
        if(!passwordCheck.equals(password)){
            errorMessage = "Passwords do not match!";
            return null;
        }

        User output = null;
        try(UserTDG gateway = new UserTDG()){
            if(gateway.findByEmail(email).next()){
                errorMessage = "User already exists!";
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
            errorMessage = "Email cannot be blank!";
            return null;
        }
        if(isEmpty(pass)){
            errorMessage = "Password cannot be blank!";
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
    private boolean credentialsFine(String name, String email, String password) {
        if(name != null && isEmpty(name)){
            errorMessage = "Name cannot be blank!";
            return false;
        }
        if(email != null && isEmpty(email) || !email.contains("@")){
            errorMessage = "Email cannot be blank!";
            return false;
        }
        if(password != null && isEmpty(password)){
            errorMessage = "Password cannot be blank!";
            return false;
        }
        return true;
    }

    private boolean isEmpty(String string){
        if(string.isEmpty() || string.isBlank()){
            return true;
        }
        return false;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
