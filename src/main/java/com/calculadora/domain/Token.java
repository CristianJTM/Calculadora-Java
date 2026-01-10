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
