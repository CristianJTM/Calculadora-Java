package com.calculadora.service;

import com.calculadora.domain.*;
import com.calculadora.domain.error.OperacionInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraService {

    public Resultado calcular(Expresion expresion) {

        List<Token> tokens = expresion.tokenizar();

        if (tokens.size() < 3) {
            throw new OperacionInvalidaException("Expresión incompleta");
        }

        List<Token> paso1  = resolverMultiplicacionesYDivisiones(tokens);
        List<Token> tokenFinal = resolverSumasYRestas(paso1);
        if (tokenFinal.size() != 1) {
            throw new OperacionInvalidaException("Error al evaluar la expresión");
        }
        double resultado = Double.parseDouble(tokenFinal.get(0).getValorNumerico());
        return new Resultado(resultado);
    }

    private List<Token> resolverMultiplicacionesYDivisiones(List<Token> tokens){
        List<Token> resultado = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            Token actual = tokens.get(i);
            if (actual.esOperador() && actual.esMultiplicacionODivision()) {

                Token izquierdo = resultado.remove(resultado.size() - 1);
                Token derecho = tokens.get(i + 1);

                double valor = aplicarOperacion(
                        Double.parseDouble(izquierdo.getValorNumerico()),
                        Double.parseDouble(derecho.getValorNumerico()),
                        actual.getTipoOperacion()
                );

                resultado.add(Token.numero(String.valueOf(valor)));
                i++;

            } else {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    private List<Token> resolverSumasYRestas(List<Token> tokens){
        List<Token> resultado = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            Token actual = tokens.get(i);
            if (actual.esOperador() && actual.esSumasORestas()) {
                Token izquierdo = resultado.remove(resultado.size() - 1);
                Token derecho = tokens.get(i + 1);

                double valor = aplicarOperacion(
                        Double.parseDouble(izquierdo.getValorNumerico()),
                        Double.parseDouble(derecho.getValorNumerico()),
                        actual.getTipoOperacion()
                );

                resultado.add(Token.numero(String.valueOf(valor)));
                i++;

            } else {
                resultado.add(actual);
            }
        }
        return resultado;


    }

    private double aplicarOperacion(double a, double b, TipoOperacion operacion) {
        return switch (operacion) {
            case SUMA -> a + b;
            case RESTA -> a - b;
            case MULTIPLICACION -> a * b;
            case DIVISION -> {
                if (b == 0) {
                    throw new OperacionInvalidaException("División por cero");
                }
                yield a / b;
            }
        };
    }
}