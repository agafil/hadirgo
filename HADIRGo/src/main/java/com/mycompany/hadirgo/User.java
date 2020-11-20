package com.mycompany.hadirgo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class User {
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
    private Label labeluser;
    @FXML
    private void backToWelcome(ActionEvent event) throws IOException {
        App.setRoot("Home");
    }
    @FXML
    public void initialize(){
        labeluser.setText(MenuLogin.getUsername());
    }    
}
