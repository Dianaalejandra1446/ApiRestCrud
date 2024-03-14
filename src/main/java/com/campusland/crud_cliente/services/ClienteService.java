package com.campusland.crud_cliente.services;


import java.util.List;

import com.campusland.crud_cliente.repositories.entities.Cliente;


public interface ClienteService {
    List<Cliente> finaAll();

    Cliente finById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);

    void update(Long id,Cliente clienteActualizado);

}
