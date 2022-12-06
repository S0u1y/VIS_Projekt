package com.example.vis_projekt;

import com.example.vis_projekt.Data_Representantives.User;
import com.example.vis_projekt.Domain_Logic.UserTM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class RegisterViewController implements AppController{

    @FXML
    private Pane screenPane;

    @FXML
    private Pane errorMessage;

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
        if(errorMessage != null){
            screenPane.getChildren().remove(errorMessage);
        }
        User usr = module.Register(0,0,name.getText(),surName.getText(),email.getText(),password.getText(), passwordCheck.getText());
        if(usr != null){
            SceneSwapperHandler.swapScenes(email.getScene(), getClass().getResource("login-view.fxml"), "Login");
        }else{
            errorMessage = setErrorMessage(module.getErrorMessage());
        }
    }

    private Pane setErrorMessage(String message){
        Pane errorPane;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("error-message.fxml"));
        try {
            errorPane = loader.load();
            screenPane.getChildren().add(errorPane);
            ((Text)(errorPane.getChildren().get(0))).setText(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return errorPane;
    }

    @Override
    public void startAppInternal(Object object) {

    }

    @Override
    public void startApp() {

    }
}
