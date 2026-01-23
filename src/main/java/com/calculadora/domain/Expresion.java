package com.calculadora.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Expresion {
    private String texto;

    public Expresion(String texto){
        this.texto = texto;
    }

    public List<Token> tokenizar() {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numeroActual = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            // Número o punto decimal
            if (Character.isDigit(c) || c == '.') {
                numeroActual.append(c);
                continue;
            }
            if (c == '-') {
                numeroActual.append(c);
                continue;
            }

            // Operador
            if (esOperador(c)) {
                // cerrar número anterior
                if (numeroActual.length() > 0) {
                    tokens.add(Token.numero(numeroActual.toString()));
                    numeroActual.setLength(0);
                }

                tokens.add(Token.operador(TipoOperacion.fromSimbolo(c)));
                continue;
            }

            // Cualquier otro carácter es inválido
            throw new IllegalArgumentException("Carácter inválido: " + c);
        }

        // último número pendiente
        if (numeroActual.length() > 0) {
            tokens.add(Token.numero(numeroActual.toString()));
        }

        return tokens;
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
