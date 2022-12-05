package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Domain_Logic.UserTM;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterViewController {

    @FXML
    private TextField name;
    @FXML
    private TextField surName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordCheck;
    @FXML
    private Button register;

    private UserTM module = new UserTM();

    @FXML
    private void onRegisterButton(){
        if(password.getText().equals(passwordCheck.getText())){
            User usr = module.Register(0,0,name.getText(),surName.getText(),email.getText(),password.getText());
            if(usr != null){
                SceneSwapperHandler.swapScenes(email.getScene(), getClass().getResource("login-view.fxml"), "Login");
            }
        }
    }


}
