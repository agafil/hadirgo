package com.mycompany.hadirgo;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuLogin {

    @FXML
    private void switchToPrimary() throws IOException {
        Hadirgo.setRoot("primary");
    }
}