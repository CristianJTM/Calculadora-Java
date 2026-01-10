package com.calculadora.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Objects;
import com.calculadora.domain.Expresion;

public class CalculadoraController {
    @FXML
    private TextField display;

    @FXML
    private void onBtnPressed(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if(Objects.equals(display.getText(),"0") && btn.getText().matches("[+*/]")){
            return;
        }else if(Objects.equals(display.getText(),"0") && btn.getText().matches("-")){
            display.setText(btn.getText());
        }else if(Objects.equals(display.getText(),"-") && btn.getText().matches("[+]")) {
            display.setText("0");
            return;
        } else if (Objects.equals(display.getText(),"-") && btn.getText().matches("[*/]")) {
            return;
        }
        esNumero(btn);
        esOperador(btn);
        puedeAgregarPunto(btn);

        if(btn.getText().matches("=")){

            //Metodo que hace las operaciones.
            //Por el momento se limpia el display

            display.setText("0");
        }
    }

    private void esNumero(Button btn){
        if(btn.getText().matches("[0-9]+")){
            if(Objects.equals(display.getText(),"0")){
                display.setText(btn.getText());
            }else{
                display.setText(display.getText() + btn.getText());
            }
        }
    }
    private void esOperador(Button btn){
        if(btn.getText().matches("[+\\-*/]")){
            if(display.getText().substring(display.getText().length() - 1).matches("[+\\-*/]")){
                display.setText(display.getText().substring(0, display.getText().length() - 1) + btn.getText());
            }else{
                display.setText(display.getText() + btn.getText());
            }
        }
    }

    private void puedeAgregarPunto(Button btn){
        if(btn.getText().matches("[.]")){
            String[] numbers = display.getText().split("[+\\-*/]");
            String lastNumber = numbers[numbers.length-1];
            if(display.getText().substring(display.getText().length() - 1).matches("[0-9]+")
                    && !lastNumber.contains(".")){
                display.setText(display.getText() + btn.getText());
            }
        }
    }
}
