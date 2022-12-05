package com.example.vis_projekt;

import com.example.vis_projekt.Domain_Logic.UserTM;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button register;

    private UserTM module = new UserTM();

    public void beginApp(){
    }

    @FXML
    private void onRegisterButton(){
        SceneSwapperHandler.swapScenes(email.getScene(), getClass().getResource("register-view.fxml"), "Register");
    }

    @FXML
    private void onLoginButton(){
        MainClass.user = module.Login(email.getText(), password.getText());
        if(MainClass.user != null){
            SceneSwapperHandler.swapScenes(email.getScene(), getClass().getResource("hello-view.fxml"), "Index");
        }else{
            password.setText("");
        }

    }

}
