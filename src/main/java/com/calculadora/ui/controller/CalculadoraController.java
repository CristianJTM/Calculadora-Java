package com.calculadora.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CalculadoraController {
    @FXML
    private Button btn;

    @FXML
    private void onBtnPressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        System.out.println(btn.getText());
    }
}
