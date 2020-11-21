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
    private boolean iniAdminBukan = false;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private void cekLogin(ActionEvent event) throws IOException{
        usr = username.getText();
        pwd = password.getText();
        status = HadirGoDb.validate(usr, pwd);
        iniAdminBukan = HadirGoDb.isAdmin(usr);
        
        if(status == true){
            App.setRoot("user");
        }
//        else if(status == true){
//            App.setRoot("dosen");
//        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User atau Password salah!");
            alert.showAndWait();
        }
    }
    
    public static String getUsername(){
        return usr;
    }
}