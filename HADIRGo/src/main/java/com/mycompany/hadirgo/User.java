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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.mycompany.hadirgo.MenuLogin;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;

/**
 *
 * @author Mocha-Chino
 */
public class User implements Initializable {
    private String username;
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
    /*
    @FXML
    private TextField namauser;
    @FXML
    private TextField namauserpakai;
    */
    @FXML
    private Label labeluser;
    
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
    MenuLogin ml = new MenuLogin();
    
    private void setUser(){
        username = ml.getUsername();
    }
    
    @FXML
    public void initialize() {
        /*
        Text currentuser = new Text();
        currentuser.setText("admin");
        currentuser.setX(214.0);
        currentuser.setY(227.0);
        currentuser.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        currentuser.setStrokeWidth(2);
        currentuser.setStroke(Color.BLUE);
        */
        labeluser.setText("admin");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
