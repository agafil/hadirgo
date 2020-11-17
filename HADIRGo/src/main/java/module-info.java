module com.mycompany.hadirgo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.mycompany.hadirgo to javafx.fxml;
    exports com.mycompany.hadirgo;
}
