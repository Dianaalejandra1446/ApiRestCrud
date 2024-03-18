package com.campusland.crud_cliente.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campusland.crud_cliente.repositories.RepositoryCliente;
import com.campusland.crud_cliente.repositories.entities.Cliente;
import com.campusland.crud_cliente.services.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService{

    private RepositoryCliente repositoryCliente;

    @Override
    @Transactional(readOnly=true)
    public List<Cliente> finaAll() {
        return (List<Cliente>)repositoryCliente.findAll();
    }

    @Override
    @Transactional(readOnly =true)
    public Cliente finById(Long id) {
        return repositoryCliente.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Cliente> clienteOptional=repositoryCliente.findById(id);
        if (clienteOptional.isPresent()) {
            repositoryCliente.delete(clienteOptional.get());
        }
    }

    /*     public void update(Long id, Cliente clienteActualizado) {
    @Override
        Optional<Cliente> buscarCliente = repositoryCliente.findById(id);
        if (buscarCliente.isPresent()) {
            Cliente clienteExistente = buscarCliente.get();
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setEmail(clienteActualizado.getEmail());
            clienteExistente.setCreateAt(clienteActualizado.getCreateAt());
            repositoryCliente.save(clienteExistente);
        }
    } */
    @Override
    public Cliente update(Long id, Cliente cliente) {
       Optional<Cliente> clienteCurrentOptional=repositoryCliente.findById(id);

       if(clienteCurrentOptional.isPresent()){
          Cliente clienteCurrent=clienteCurrentOptional.get();
          clienteCurrent.setNombre(cliente.getNombre());
          clienteCurrent.setApellido(cliente.getApellido());
          clienteCurrent.setEmail(cliente.getEmail()); 
          repositoryCliente.save(clienteCurrent);
          return clienteCurrent;         
       }

       return null;    
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findByEmail(String email) {
        return repositoryCliente.findByEmail(email);
    }
    
    
}
