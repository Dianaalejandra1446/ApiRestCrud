package com.campusland.crud_cliente.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.Cliente;
import com.campusland.crud_cliente.services.ClienteService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> findAll() {
        return clienteService.finaAll();
    }

    @GetMapping("/{id}")
    public Cliente findAllById(@PathVariable Long id) {
        return clienteService.finById(id);
    }

    @PostMapping("/")
    public Cliente save(@RequestBody Cliente cliente) {        
        return clienteService.save(cliente);
    }
    
    @DeleteMapping("/")
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
    
}
