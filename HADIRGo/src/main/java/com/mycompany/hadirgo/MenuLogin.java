package com.mycompany.hadirgo;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.TextField;

public class MenuLogin {
    private static String usr;
    private String pwd;
    private boolean status = false;
    
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private void cekLogin(ActionEvent event) throws IOException{
        usr = username.getText();
        pwd = password.getText();
        status = HadirGoDb.validate(usr, pwd);
        
        if(status == true){
            App.setRoot("user");
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User tidak ketemu!");
            alert.showAndWait();
        }
    }
    
    public static String getUsername(){
        return usr;
    }
}