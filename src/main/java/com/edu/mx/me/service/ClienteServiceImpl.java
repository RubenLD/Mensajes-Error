package com.edu.mx.me.service;

import com.edu.mx.me.entity.Cliente;
import com.edu.mx.me.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl{

    @Autowired
    private IClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).get();
    }

    public void guardar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
