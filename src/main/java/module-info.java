module com.bruijs.thomas.rentathingopt3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bruijs.thomas.rentathingopt3 to javafx.fxml;
    exports com.bruijs.thomas.rentathingopt3;
    exports com.bruijs.thomas.rentathingopt3.controller;
    exports com.bruijs.thomas.rentathingopt3.model;

    opens com.bruijs.thomas.rentathingopt3.controller to javafx.fxml;
}