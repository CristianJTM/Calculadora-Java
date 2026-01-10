package com.calculadora.domain;

public enum TipoOperacion {

    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/");

    private final String simbolo;

    TipoOperacion(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static TipoOperacion fromSimbolo(String simbolo) {
        for (TipoOperacion tipo : values()) {
            if (tipo.simbolo.equals(simbolo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Operación no soportada: " + simbolo);
    }
}
