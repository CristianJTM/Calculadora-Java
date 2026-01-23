package com.calculadora.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Objects;
import com.calculadora.domain.Expresion;
import com.calculadora.service.CalculadoraService;
import com.calculadora.domain.Resultado;

public class CalculadoraController {
    @FXML
    private TextField display;

    private CalculadoraService calculadoraService = new CalculadoraService();


    @FXML
    private void onBtnPressed(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if(Objects.equals(display.getText(),"0") && btn.getText().matches("[+*/]")){
            return;
        }
        if(Objects.equals(display.getText(),"0") && btn.getText().matches("-")){
            display.setText(btn.getText());
        }
        if(Objects.equals(display.getText(),"-") && btn.getText().matches("[+]")) {
            display.setText("0");
            return;
        }
        if (Objects.equals(display.getText(),"-") && btn.getText().matches("[*/]")) {
            return;
        }
        if (display.getText().substring(display.getText().length() - 1).matches("[+*/]") && btn.getText().matches("-")) {
            display.setText(display.getText() + btn.getText());
        }
        if (display.getText().length() >= 2 &&
                (display.getText().endsWith("+-")
                        || display.getText().endsWith("*-")
                        || display.getText().endsWith("/-")) &&
                btn.getText().matches("[+\\-*/]")) {
            return;
        }
        esNumero(btn);
        esOperador(btn);
        puedeAgregarPunto(btn);
        esLimpiador(btn);

        if(btn.getText().matches("=")){

            String textoExpresion = display.getText();

            Expresion expresion = new Expresion(textoExpresion);

            Resultado resultado = calculadoraService.calcular(expresion);

            display.setText(resultado.comoTexto());

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
    private void esLimpiador(Button btn){
        if(btn.getText().matches("C")){
            display.setText("0");
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
