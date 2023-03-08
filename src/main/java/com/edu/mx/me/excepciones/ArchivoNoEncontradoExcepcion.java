package com.edu.mx.me.excepciones;

import java.io.FileNotFoundException;

public class ArchivoNoEncontradoExcepcion extends FileNotFoundException {

    public ArchivoNoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
