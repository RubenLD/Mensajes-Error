package com.edu.mx.me.controller;

import com.edu.mx.me.excepciones.ArchivoNoEncontradoExcepcion;
import com.edu.mx.me.excepciones.DivisionPorZeroExcepcion;
import com.edu.mx.me.excepciones.FormatoNumeroExcepcion;
import com.edu.mx.me.excepciones.ValorNuloExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlExcepciones {

    @ExceptionHandler(DivisionPorZeroExcepcion.class)
    public String divisionPorZero(DivisionPorZeroExcepcion de, Model model){
        model.addAttribute("titulo", "ArithmeticException");
        model.addAttribute("mensajeError", de.getMessage());
        return "excepciones/operaciones";
    }

    @ExceptionHandler(FormatoNumeroExcepcion.class)
    public String numeroFormatoError(FormatoNumeroExcepcion fe, Model model){
        model.addAttribute("titulo", "NumberFormatException");
        model.addAttribute("mensajeError", fe.getMessage());
        return "excepciones/operaciones";
    }

    @ExceptionHandler(ValorNuloExcepcion.class)
    public String valorNulo(ValorNuloExcepcion ve, Model model){
        model.addAttribute("titulo", "NullPointerException");
        model.addAttribute("mensajeError", ve.getMessage());
        return "excepciones/comparacion";
    }

    @ExceptionHandler(ArchivoNoEncontradoExcepcion.class)
    public String archivoNoEncontrado(ArchivoNoEncontradoExcepcion ae, Model model){
        model.addAttribute("titulo", "FileNotFoundException");
        model.addAttribute("mensajeError", ae.getMessage());
        return "excepciones/buscar-archivo";
    }


}
