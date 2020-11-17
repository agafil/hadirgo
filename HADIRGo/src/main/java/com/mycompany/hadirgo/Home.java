package com.mycompany.hadirgo;

import java.io.IOException;
//import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Home implements Initializable {
    /*
    @FXML
    private login;
    */
    @FXML
    private AnchorPane register;
    @FXML
    private AnchorPane home;
    @FXML
    private Button login;
   
    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        //JButton login = new JButton;
        App.setRoot("FormLogin");
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
