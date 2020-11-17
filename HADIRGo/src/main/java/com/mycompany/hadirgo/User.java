/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hadirgo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Mocha-Chino
 */
public class User implements Initializable {
    @FXML
    private AnchorPane register;
    @FXML
    private AnchorPane home;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane user;
    @FXML
    private Button login;
   
    @FXML
    private void backToWelcome(ActionEvent event) throws IOException {
        //JButton login = new JButton;
        App.setRoot("Home");
    }
    
    
    /*
    @FXML
    private void handleButtonAction(MouseEvent event){
        if(event.getTarget() == login){
            register.setVisible(true);
        }
    }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
