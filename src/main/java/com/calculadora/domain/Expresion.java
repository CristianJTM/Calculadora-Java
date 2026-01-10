package com.calculadora.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Expresion {
    private String texto;

    public Expresion(String texto){
        this.texto = texto;
    }

    public List<Token> tokenizar(){
        List<Token> expresionToken = new ArrayList<>();
        String stringBuilder;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.substring()){

            }
        }
        return expresionToken;
    }
}
