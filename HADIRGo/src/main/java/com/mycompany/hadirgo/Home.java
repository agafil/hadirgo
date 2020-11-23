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
import com.jfoenix.controls.JFXButton;

public class Home implements Initializable {
    
    @FXML
    private AnchorPane home;
    
    @FXML
    private JFXButton signInbtn;

    @FXML
    //private void switchToLogin(ActionEvent event) throws IOException {
    private void switchToUser(ActionEvent event) throws IOException {
        //JButton login = new JButton;
        //App.setRoot("FormLogin");
        App.setRoot("user");
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
