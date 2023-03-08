package com.edu.mx.me.controller;

import com.edu.mx.me.entity.Cliente;
import com.edu.mx.me.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("clientes", clienteService.listar());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/crear")
    public String form(Model model){
        model.addAttribute("titulo", "Registro de clientes");
        model.addAttribute("cliente", new Cliente());
        return "views/form";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public String registro(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public String formEdit(@PathVariable Long id, Model model){
        model.addAttribute("titulo", "Modificar cliente");
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "views/edit";
    }
}
