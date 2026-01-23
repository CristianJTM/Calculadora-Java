package com.calculadora.domain;

public class Token {
    private TipoToken tipo;
    private String valorNumerico;
    private TipoOperacion tipoOperacion;

    private Token() {
    }

    public static Token numero(String valor) {
        Token token = new Token();
        token.tipo = TipoToken.NUMERO;
        token.valorNumerico = valor;
        return token;
    }

    public static Token operador(TipoOperacion tipoOperacion) {
        Token token = new Token();
        token.tipo = TipoToken.OPERADOR;
        token.tipoOperacion = tipoOperacion;
        return token;
    }

    public boolean esOperador() {
        return tipo == TipoToken.OPERADOR;
    }

    public boolean esMultiplicacionODivision() {
        return tipo == TipoToken.OPERADOR &&
                (tipoOperacion == TipoOperacion.MULTIPLICACION ||
                        tipoOperacion == TipoOperacion.DIVISION);
    }

    public boolean esSumasORestas() {
        return tipo == TipoToken.OPERADOR &&
                (tipoOperacion == TipoOperacion.SUMA ||
                        tipoOperacion == TipoOperacion.RESTA);
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getValorNumerico() {
        return valorNumerico;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }


}
