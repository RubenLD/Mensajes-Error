package com.edu.mx.me.controller;

import com.edu.mx.me.excepciones.ArchivoNoEncontradoExcepcion;
import com.edu.mx.me.excepciones.DivisionPorZeroExcepcion;
import com.edu.mx.me.excepciones.FormatoNumeroExcepcion;
import com.edu.mx.me.excepciones.ValorNuloExcepcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;

@Controller
public class OperacionController {

    @GetMapping("/operacion")
    public String operacion(){
        return "excepciones/operaciones";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("n1") String n1, @RequestParam("n2") String n2, Model model) {
        try {
            int numero1 = Integer.parseInt(n1);
            int numero2 = Integer.parseInt(n2);

            if(numero2 == 0){
                throw new DivisionPorZeroExcepcion("No se puede realizar la división entre 0");
            }
            model.addAttribute("resul", (numero1/numero2));
            return "excepciones/operaciones";
        } catch (NumberFormatException ex) {
            throw new FormatoNumeroExcepcion("El valor no es un número válido");
        }
    }

    @GetMapping("/comparacion")
    public String comparacion(){
        return "excepciones/comparacion";
    }

    @PostMapping("/comparar")
    public String comparar(@RequestParam String pal1, @RequestParam String pal2, Model model){
        if(pal1.equals("")){
            pal1 = null;
        }else if(pal2.equals("")){
            pal2 = null;
        }
        if(pal1 == null || pal2 == null){
           throw new ValorNuloExcepcion("No se aceptan valores nulos");
        }

        if(pal1.equalsIgnoreCase(pal2)){
            model.addAttribute("resul", "Las palabras son iguales");
        }else{
            model.addAttribute("resul", "Las palabras no son iguales");
        }

        return "excepciones/comparacion";
    }

    @GetMapping("/buscar")
    public String formArchivo(){
        return "excepciones/buscar-archivo";
    }

    @PostMapping("/buscar-archivo")
    public String buscarArchivo(@RequestParam String archivo, Model model) throws ArchivoNoEncontradoExcepcion {
        String ruta = System.getProperty("user.home") + "/Documents/"+archivo;

        File archi = new File(ruta);
        if (!archi.exists()) {
            throw new ArchivoNoEncontradoExcepcion("El archivo no se encontró en la ruta especificada.");
        }else{
            model.addAttribute("resul", "Archivo encontrado!");
        }
        return "excepciones/buscar-archivo";
    }

}
