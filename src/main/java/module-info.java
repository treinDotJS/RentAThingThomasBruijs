module com.bruijs.thomas.rentathingopt3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bruijs.thomas.rentathingopt3 to javafx.fxml;
    exports com.bruijs.thomas.rentathingopt3;
}