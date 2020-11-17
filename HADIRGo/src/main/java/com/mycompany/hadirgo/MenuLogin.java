package com.mycompany.hadirgo;

import javafx.fxml.FXML;
import java.io.IOException;
//import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import static com.mycompany.hadirgo.HadirGoDb.*;
import java.lang.ProcessBuilder.Redirect.Type;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.TextField;
import java.lang.reflect.Method;

public class MenuLogin extends HadirGoDb{
    private String user;
    private String pwd;
    private boolean status;
    
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    /*
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Home");
    }
    */
    @FXML
    private void cekLogin(ActionEvent event) throws IOException{
        user = username.getText();
        pwd = password.getText();
        status = HadirGoDb.validate(user, pwd);
        
        if(status){
            App.setRoot(user);
        }
        else{
            //System.out.println("User tidak ketemu!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User tidak ketemu!");
            alert.showAndWait();
        }
    }
    /*
    private void registerUser(ActionEvent event) throws IOException{
        
    }
    */
}