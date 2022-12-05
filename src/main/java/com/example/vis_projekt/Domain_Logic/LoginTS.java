package com.example.vis_projekt.Domain_Logic;

import com.example.vis_projekt.Data_Access.UserTDG;
import com.example.vis_projekt.Encoding;

import java.sql.SQLException;

public class LoginTS {

    public boolean login(String email, String password){
        String hashPass = Encoding.Hash(password);
        String cmpPass = null;
        try(UserTDG gateway = new UserTDG()){
            cmpPass = gateway.findByEmail(email).getString("Password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cmpPass.equals(hashPass);
    }

}
