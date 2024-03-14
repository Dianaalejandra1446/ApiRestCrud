package com.campusland.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.Cliente;

// La interface se comporta como un bean
public interface RepositoryCliente extends CrudRepository<Cliente,Long>{
    
}
