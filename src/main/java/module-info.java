module com.calculadora.calculadorafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculadora.app to javafx.fxml;
    opens com.calculadora.ui.controller to javafx.fxml;
    exports com.calculadora.app;
}