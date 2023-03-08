package com.edu.mx.me.excepciones;

public class DivisionPorZeroExcepcion extends ArithmeticException{
    public DivisionPorZeroExcepcion(String mensaje){
        super(mensaje);
    }
}
