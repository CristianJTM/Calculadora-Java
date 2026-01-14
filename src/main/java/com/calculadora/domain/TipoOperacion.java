package com.calculadora.domain;

public enum TipoOperacion {

    SUMA('+'),
    RESTA('-'),
    MULTIPLICACION('*'),
    DIVISION('/');
    private final char simbolo;

    TipoOperacion(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public static TipoOperacion fromSimbolo(char simbolo) {
        for (TipoOperacion op : values()) {
            if (op.simbolo == simbolo) {
                return op;
            }
        }
        throw new IllegalArgumentException("Operador no soportado: " + simbolo);
    }
}
