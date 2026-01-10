package com.calculadora.domain.error;

public class OperacionInvalidaException extends RuntimeException{
    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
