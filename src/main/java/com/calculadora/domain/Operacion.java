package com.calculadora.domain;
import com.calculadora.domain.error.OperacionInvalidaException;

public class Operacion {
    private final TipoOperacion tipo;

    public Operacion(TipoOperacion tipo) {
        this.tipo = tipo;
    }

    public double ejecutar(double a, double b) {
        switch (tipo) {
            case SUMA:
                return a + b;

            case RESTA:
                return a - b;

            case MULTIPLICACION:
                return a * b;

            case DIVISION:
                if (b == 0) {
                    throw new OperacionInvalidaException("No se puede dividir por cero");
                }
                return a / b;

            default:
                throw new OperacionInvalidaException("Operación no soportada: " + tipo);
        }
    }
}
