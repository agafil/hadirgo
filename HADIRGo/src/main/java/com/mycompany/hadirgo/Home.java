package com.mycompany.hadirgo;

import java.io.IOException;
import javafx.fxml.FXML;

public class Home {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
